package com.endgame.controller;

import com.endgame.dao.QuestionDao;
import com.endgame.model.Question;
import com.endgame.model.User;
import com.endgame.util.QuestionMapper;
import com.endgame.util.UrlTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class QuestionController {

    @Autowired
    QuestionDao questionDao;
    private Map<String, Integer> questIdAndMap;

    @RequestMapping(value = "/displayQuestion", method = RequestMethod.POST)
    protected ModelAndView displayQuestion(@SessionAttribute("user") User user, @RequestParam("1") String answer,
                                           @RequestParam("2") String answer2,
                                           @RequestParam("3") String answer3,
                                           @RequestParam("4") String answer4,
                                           @RequestParam("5") String answer5,
                                           @RequestParam("6") String answer6,
                                           @RequestParam("7") String answer7,
                                           ModelAndView modelAndView) throws NoSuchAlgorithmException {
        System.out.println(user.getUsername());
        List<Question> answersList = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        answers.add(answer);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        answers.add(answer5);
        answers.add(answer6);
        answers.add(answer7);
        System.out.println(answer2);
        questIdAndMap = QuestionMapper.questIdAnsMap();
        answers.forEach(
                ans -> {
                    Question question = new Question();
                    question.setName(user.getUsername());
                    question.setAnswer(ans);
                    question.setQuestionId(questIdAndMap.get(ans));
                    answersList.add(question);
                }
        );
        String s = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
        String hostname = UrlTransformer.getUrlDomainName(s);
        String url = null;
        try {
            url = UrlTransformer.generateUrl(hostname, user.getUsername());
            //check user and id already exists;
            List<Integer> insertChecks = new ArrayList<>();
            List<Integer> updateChecks = new ArrayList<>();
            for (Question question : answersList) {
                Question q = questionDao.getQuestionByUserAndId(question.getName(), question.getQuestionId());
                if (q != null) {
                    int updateCheck = questionDao.updateQuestionAns(question);
                    updateChecks.add(updateCheck);
                    if (updateCheck == 0)
                        System.out.println("updation of ans for the question" + question.getQuestionId() + "failed");
                } else {
                    int insertCheck = questionDao.insertQuestion(question);
                    insertChecks.add(insertCheck);
                    if (insertCheck == 0)
                        System.out.println("insertion of ans for the question" + question.getQuestionId() + "failed");
                }
            }
            if (!insertChecks.contains(0) && !updateChecks.contains(0)) {
                System.out.println("All Answers Updated Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(hostname);
        System.out.println(url);
        modelAndView = new ModelAndView("urlview");
        modelAndView.addObject("urlfinal", url);

        return modelAndView;
    }
}
