package com.endgame.controller;

import com.endgame.dao.QuestionDao;
import com.endgame.model.ConsumerUser;
import com.endgame.model.DisplayResult;
import com.endgame.model.Question;
import com.endgame.model.Qview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@SessionAttributes("ConsumerUser")
public class ConsumerUrlController {
  private static Map<Integer, String> quesOptMap = new LinkedHashMap<>();
  private static Map<Integer, List<String>> idAndAns = new LinkedHashMap<>();

  static {
    quesOptMap.put(1, "what do you prefer eating in the middle of movie?");
    quesOptMap.put(2, "if you get a chance to travel where will you prefer?");
    quesOptMap.put(3, "what makes you happy?");
    quesOptMap.put(4, "what type of marriage you will prefer?");
    quesOptMap.put(5, "In which below industry you loved to work?");
    quesOptMap.put(6, "what you are believe in?");
    quesOptMap.put(7, "what kind of guy you are?");
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
    List<String> opts4 =
            new ArrayList<>(
                    Arrays.asList(
                            "TechOrFinance", "Manufacturer&Engineering", "Entertainment", "Agriculture"));
    idAndAns.put(5, opts4);
    List<String> opts5 = new ArrayList<>(Arrays.asList("God", "MysticalForce", "NoOne", "Karma"));
    idAndAns.put(6, opts5);
    List<String> opts6 = new ArrayList<>(Arrays.asList("soft", "active", "tough", "lazy"));
    idAndAns.put(7, opts6);
  }

  @Autowired
  QuestionDao questionDao;

  @ModelAttribute("ConsumerUser")
  public ConsumerUser setupConsumerForm() {
    return new ConsumerUser() {
    };
  }

  @RequestMapping(value = "/endgame/user/{username}", method = RequestMethod.GET)
  public ModelAndView consumerProcessEntry(@PathVariable String username) {
    ModelAndView modelAndView = new ModelAndView("frienddetails");
    modelAndView.addObject("parentuser", username);
    return modelAndView;
  }

  @RequestMapping(value = "/displayConsumerQuestions", method = RequestMethod.POST)
  public ModelAndView displayConsumerQuestions(
          @ModelAttribute("ConsumerUser") ConsumerUser consumerUser) {
    ConsumerUser checkUserExists = questionDao.getConsumerByParentUser(consumerUser);
    ModelAndView modelAndView = null;
    if (checkUserExists == null) {
      int check = questionDao.insertDefaultScore(consumerUser);
      if (check == 0) {
        modelAndView = new ModelAndView("frienddetails");
        modelAndView.addObject("error", "defualt Score update failed");
      }
      Qview qview = new Qview();
      qview.setId(1);
      qview.setQuestion(quesOptMap.get(1));
      qview.setOptions(idAndAns.get(1));
      modelAndView = new ModelAndView("consumerQ");
      modelAndView.addObject("qview", qview);

    } else {
      modelAndView = new ModelAndView("frienddetails");
      modelAndView.addObject(
              "error", "You have already Answered.if not please try to give your full name");
    }
    return modelAndView;
  }

  @RequestMapping(value = "/processConsumerQuestions", method = RequestMethod.POST)
  public ModelAndView processConsumerQuestions(
          @SessionAttribute("ConsumerUser") ConsumerUser consumerUser,
          @RequestParam("game") String answer,
          @RequestParam("id") String id,
          ModelAndView modelAndView) {
    // Main User Question and Answers

    DisplayResult displayResult = questionDao.getResult(consumerUser);
    int showResultCheck = questionDao.getShowResult(consumerUser);
    if (showResultCheck == 1) {
      modelAndView = new ModelAndView("success");

      modelAndView.addObject("result", displayResult.getResult());
      return modelAndView;
    }
    int qid = Integer.parseInt(id);
    Question EndUserQuestion = questionDao.getAnsByQuesId(consumerUser.getParentUser(), id);
    int result = 0;
    if (EndUserQuestion != null & displayResult != null) {
      if (EndUserQuestion.getAnswer().equals(answer)) {
        result = displayResult.getResult() + 1;
        int updatecheck = questionDao.updateResult(consumerUser, result, 0);
        if (updatecheck == 0) {
          System.out.println("score update failed for the question" + result); // debug
          modelAndView = new ModelAndView("error");
          modelAndView.addObject("errmsg", "Score Update Failed");
          return modelAndView;
        }
      }
    } else {
      modelAndView = new ModelAndView("error");
      modelAndView.addObject(
              "errmsg",
              "your friend updated the ans with wrong session ask him to resubmit the questions and send the llink again");
      return modelAndView;
    }
    if (qid <= 6) {
      qid = qid + 1;
      Qview qview = new Qview();
      qview.setId(qid);
      qview.setQuestion(quesOptMap.get(qid));
      qview.setOptions(idAndAns.get(qid));
      modelAndView = new ModelAndView("consumerQ");
      modelAndView.addObject("qview", qview);
      return modelAndView;
    } else {
      int UpdateShowResult = questionDao.updateShowResultToONe(consumerUser);
      if (UpdateShowResult == 1) {
        modelAndView = new ModelAndView("success");
        DisplayResult displayResultintial = questionDao.getResult(consumerUser);
        modelAndView.addObject("result", displayResultintial.getResult());
      } else {
        modelAndView = new ModelAndView("error");
        modelAndView.addObject("errmsg", "update show result failed");
        return modelAndView;
      }
    }
    return modelAndView;
  }
}
