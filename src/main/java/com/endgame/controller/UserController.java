package com.endgame.controller;

import com.endgame.dao.LoginDao;
import com.endgame.model.DisplayResult;
import com.endgame.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.endgame.util.RandomPassword.randomPassword;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    LoginDao loginDao;
    @Autowired
    EndGameMail endGameMail;

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

    @PostMapping("/forgotpasswordprocess")
    public ModelAndView forgotPasswordProcess(ModelAndView model, @RequestParam("email") String toEmail) {
        String randomPassword = randomPassword();

        int updatecheck = loginDao.updatePasswordViaMail(toEmail, randomPassword);
        if (updatecheck != 0) {
            String sentcheck = endGameMail.endGameReadyToSendEmail(toEmail, "prudhvi3914@gmail.com", "end game password!", randomPassword);
            model = new ModelAndView("login");
            if (!sentcheck.equals("OK")) {
                model.addObject("msg", "Encounter an issue while sending a password to you mail");
                return model;
            }
            model.addObject("msg", "password has been sent to your registered mail");
        }
        return model;
    }

    @RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
    protected ModelAndView forgotpassword() {
        ModelAndView modelandview = new ModelAndView("forgotpassword");
        return modelandview;
    }
}
