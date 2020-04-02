package com.endgame.controller;

import com.endgame.dao.LoginDao;
import com.endgame.model.DisplayResult;
import com.endgame.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    LoginDao loginDao;

    @GetMapping("/displayfreindsResult")
    public ModelAndView displayResults(@SessionAttribute("user") User user, ModelAndView modelAndView) {
        if (user.getUsername() != null) {
            List<DisplayResult> friendsList = loginDao.getfreindsList(user.getUsername());
            friendsList.forEach(
                    displayResult -> {
                        System.out.println("friend:" + displayResult.getUser() + ",Score:" + displayResult.getScore());
                    });
            if (friendsList != null) {
                modelAndView = new ModelAndView("displayresult");
                modelAndView.addObject("friendresults", friendsList);
            } else {
                modelAndView = new ModelAndView("displayresult");
                modelAndView.addObject("info", "No one Answered the questions!!");
            }
        }
        return modelAndView;
    }
}
