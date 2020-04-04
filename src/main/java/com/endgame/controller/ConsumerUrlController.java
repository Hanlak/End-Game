package com.endgame.controller;

import com.endgame.dao.QuestionDao;
import com.endgame.model.ConsumerUser;
import com.endgame.model.Question;
import com.endgame.util.AnswerCheckerUtil;
import com.endgame.util.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@SessionAttributes("ConsumerUser")
public class ConsumerUrlController {
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
    public ModelAndView displayConsumerQuestions(@ModelAttribute("ConsumerUser") ConsumerUser consumerUser) {
        ConsumerUser checkUserExists = questionDao.getConsumerByParentUser(consumerUser);
        ModelAndView modelAndView = null;
        if (checkUserExists == null) {
            int check = questionDao.insertDefaultScore(consumerUser);
            if (check == 0) {
                modelAndView = new ModelAndView("frienddetails");
                modelAndView.addObject("errmsg", "defualt Score update failed");
            }
            modelAndView = new ModelAndView("consumerQ");
        } else {
            modelAndView = new ModelAndView("frienddetails");
            modelAndView.addObject("errmsg", "You have already Answered.if not please try to give your full name");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/processConsumerQuestions", method = RequestMethod.POST)
    public ModelAndView processConsumerQuestions(@SessionAttribute("ConsumerUser") ConsumerUser consumerUser,
                                                 @RequestParam("1") String answer,
                                                 @RequestParam("2") String answer2,
                                                 @RequestParam("3") String answer3,
                                                 @RequestParam("4") String answer4,
                                                 @RequestParam("5") String answer5,
                                                 @RequestParam("6") String answer6,
                                                 @RequestParam("7") String answer7) {
        System.out.println(consumerUser.getParentUser());
        ModelAndView modelAndView = null;
        Map<String, Integer> questandAnsId = QuestionMapper.questIdAnsMap();
        List<String> answers = new ArrayList<>();
        answers.add(answer);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        answers.add(answer5);
        answers.add(answer6);
        answers.add(answer7);
        //ConsumerQuestionAndAnswerList
        List<Question> consumerList = new ArrayList<>();
        for (String ans : answers) {
            Question consumerquestionObj = new Question();
            consumerquestionObj.setName(consumerUser.getParentUser());
            consumerquestionObj.setQuestionId(questandAnsId.get(ans));
            consumerquestionObj.setAnswer(ans);
            consumerList.add(consumerquestionObj);
        }
        //Main User Question and Answers
        List<Question> EndUserQuestions = questionDao.getAllQuestionOfUser(consumerUser.getParentUser());
        int result = 0;
        if (EndUserQuestions != null) {
            //compare to two list objects
            result = AnswerCheckerUtil.validateAnswers(consumerList, EndUserQuestions);
            if (result == -1) {
                modelAndView = new ModelAndView("error");
                modelAndView.addObject("errmsg", "Count of Questions Answer by your friend and the ans you opted are not matching");
                return modelAndView;
            }
            int updatecheck = questionDao.updateResult(consumerUser, result);
            if (updatecheck == 0) {
                System.out.println("score update fialed" + result);//debug
                modelAndView = new ModelAndView("error");
                modelAndView.addObject("errmsg", "Score Update Failed");
                return modelAndView;
            }
        } else {
            modelAndView = new ModelAndView("error");
            modelAndView.addObject("errmsg", "Something Wrong with Url Please ask your friend to resend the link");
            return modelAndView;
        }
        modelAndView = new ModelAndView("success");
        modelAndView.addObject("result", result);

        return modelAndView;
    }
}
