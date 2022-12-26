package com.endgame.controller;

import com.endgame.dao.QuestionDao;
import com.endgame.model.Question;
import com.endgame.model.Qview;
import com.endgame.model.User;
import com.endgame.util.UrlTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.*;

@Controller
public class QuestionController {

    private static final Map<Integer, String> quesOptMap = new LinkedHashMap<>();
    private static final Map<Integer, List<String>> idAndAns = new LinkedHashMap<>();

    static {
        quesOptMap.put(1, "what do you prefer eating in the middle of movie?");
        quesOptMap.put(2, "if you get a chance to travel where will you prefer?");
        quesOptMap.put(3, "what makes you happy?");
        quesOptMap.put(4, "what type of marriage you will prefer?");
        quesOptMap.put(5, "In which below industry you loved to work?");
        quesOptMap.put(6, "what you are believe in?");
        quesOptMap.put(7, "what kind of guy/girl you are?");
        List<String> opts = new ArrayList<>();
        opts.add("Popcorn");
        opts.add("IceCream");
        opts.add("Drink");
        opts.add("FrenchFries");
        idAndAns.put(1, opts);
        List<String> opts1 = new ArrayList<>();
        opts1.add("NorthIndia");
        opts1.add("southIndia");
        opts1.add("eastasia");
        opts1.add("europe");
        idAndAns.put(2, opts1);
        List<String> opts2 = new ArrayList<>();
        opts2.add("Home");
        opts2.add("work");
        opts2.add("travel");
        opts2.add("Movies");
        idAndAns.put(3, opts2);
        List<String> opts3 = new ArrayList<>();
        opts3.add("Love");
        opts3.add("Love&Arrange");
        opts3.add("Arranged");
        opts3.add("Bachelor");
        idAndAns.put(4, opts3);
        List<String> opts4 = new ArrayList<>(Arrays.asList("TechOrFinance", "Manufacturer&Engineering", "Entertainment", "Agriculture"));
        idAndAns.put(5, opts4);
        List<String> opts5 = new ArrayList<>(Arrays.asList("God", "MysticalForce", "NoOne", "Karma"));
        idAndAns.put(6, opts5);
        List<String> opts6 = new ArrayList<>(Arrays.asList("soft", "active", "tough", "lazy"));
        idAndAns.put(7, opts6);
    }

    @Autowired
    QuestionDao questionDao;
    private Map<String, Integer> questIdAndMap;

    @GetMapping("/basequestion")
    public ModelAndView showBaseQuestion(ModelAndView mv) {
        Qview qview = new Qview();
        qview.setId(1);
        qview.setQuestion(quesOptMap.get(1));
        qview.setOptions(idAndAns.get(1));
        mv = new ModelAndView("questions");
        mv.addObject("qview", qview);
        return mv;
    }

    @GetMapping("/showlink")
    public ModelAndView showLink(@SessionAttribute("user") User user, ModelAndView modelAndView) {
        String s = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
        String hostname = UrlTransformer.getUrlDomainName(s);
        String url = UrlTransformer.generateUrl(hostname, user.getUsername());
        modelAndView = new ModelAndView("urlview");
        if (!hostname.isEmpty()) {
            modelAndView.addObject("urlfinal", url);
        } else {
            modelAndView.addObject("urlfinal", "we are having problem with generating url.");
        }
        return modelAndView;

    }

    @RequestMapping(value = "/displayQuestion", method = RequestMethod.POST)
    protected ModelAndView displayQuestion(@SessionAttribute("user") User user,
                                           @RequestParam("game") String answer,
                                           @RequestParam("id") String id,
                                           ModelAndView modelAndView) {
        System.out.println(user.getUsername());
        System.out.println(id);
        System.out.println(answer);
        int qid = Integer.parseInt(id);
        if (qid != 7) {
            Question question = new Question();
            question.setName(user.getUsername());
            question.setAnswer(answer);
            question.setQuestionId(qid);
            boolean check = questionUpdateUtil(question);
            qid = qid + 1;
            Qview qview = new Qview();
            qview.setId(qid);
            qview.setQuestion(quesOptMap.get(qid));
            qview.setOptions(idAndAns.get(qid));
            modelAndView = new ModelAndView("questions");
            modelAndView.addObject("qview", qview);
            if (!check) {
                modelAndView.addObject("error", "prev question update failed");
                //show the question again.
            }
            return modelAndView;
        }
        Question question = new Question();
        question.setName(user.getUsername());
        question.setAnswer(answer);
        question.setQuestionId(qid);
        boolean check = questionUpdateUtil(question);
        String s = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
        String hostname = UrlTransformer.getUrlDomainName(s);
        String url = UrlTransformer.generateUrl(hostname, user.getUsername());
        System.out.println(hostname);
        System.out.println(url);
        modelAndView = new ModelAndView("urlview");
        modelAndView.addObject("urlfinal", url);
        return modelAndView;
    }

    private boolean questionUpdateUtil(Question question) {
        Question q = questionDao.getQuestionByUserAndId(question.getName(), question.getQuestionId());

        if (q != null) {
            int updateCheck = questionDao.updateQuestionAns(question);
            if (updateCheck == 0) {
                System.out.println(
                        "update ans for the question" + question.getQuestionId() + "failed");
                return false;
            }
            return true;
        } else {
            int insertCheck = questionDao.insertQuestion(question);
            if (insertCheck == 0) {
                System.out.println(
                        "insertion of ans for the question" + question.getQuestionId() + "failed");
                return false;
            }
            return true;
        }

    }
}
