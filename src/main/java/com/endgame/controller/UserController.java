package com.endgame.controller;

import com.endgame.dao.UserDao;
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
    EndGameMail endGameMail;
    @Autowired
    UserDao userDao;

    @GetMapping("/displayfreindsResult")
    public ModelAndView displayResults(@SessionAttribute("user") User user, ModelAndView modelAndView) {

        modelAndView = new ModelAndView("displayresult");
        if (user.getUsername() != null) {
            List<DisplayResult> friendsList = userDao.getfreindsList(user.getUsername());
            friendsList.forEach(
                    displayResult -> {
                        System.out.println("friend:" + displayResult.getConsumer() + ",Score:" + displayResult.getResult());
                    });
            if (friendsList != null) {
                modelAndView.addObject("friendresults", friendsList);
            } else {
                modelAndView.addObject("info", "No one Answered the questions!!");
            }
        } else {
            modelAndView.addObject("info", "It seems the session is expired please login again");
        }
        return modelAndView;
    }

    @PostMapping("/forgotpasswordprocess")
    public ModelAndView forgotPasswordProcess(ModelAndView model, @RequestParam("email") String toEmail) {
        String randomPassword = randomPassword();

        int updatecheck = userDao.updatePasswordViaMail(toEmail, randomPassword);
        if (updatecheck != 0) {
            String sentcheck = endGameMail.endGameReadyToSendEmail(toEmail, "prudhvi3914@gmail.com", "end game password!", randomPassword);
            model = new ModelAndView("login");
            if (!sentcheck.equals("OK")) {
                model.addObject("error", "Encounter an issue while sending a password to you mail");
                return model;
            }
            model.addObject("error", "password has been sent to your registered mail");
        }
        return model;
    }

    @RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
    protected ModelAndView forgotpassword() {
        ModelAndView modelandview = new ModelAndView("forgotpassword");
        return modelandview;
    }

    @GetMapping("/about")
    public ModelAndView about(ModelAndView model) {
        model = new ModelAndView("about");
        return model;
    }

    @GetMapping("/emailupdate")
    public ModelAndView updateemail() {
        return new ModelAndView("emailupdate");
    }

    @GetMapping("/updatepassword")
    public ModelAndView updatePassword() {
        return new ModelAndView("updatepassword");
    }

    @PostMapping("/updatepasswordprocess")
    public ModelAndView updatePasswordProcessor(@SessionAttribute("user") User user, @RequestParam("password") String password) {
        int updatecheck = userDao.updatePasswordViaUser(user.getUsername(), password);
        if (updatecheck != 0) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "password updated sucessfully");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("updatepassword");
        modelAndView.addObject("error", "update password failed");
        return modelAndView;
    }

    @PostMapping("/updateemailprocess")
    public ModelAndView updateEmailProcessor(@SessionAttribute("user") User user, String email) {
        int updatecheck = userDao.updateEmailViaUser(user.getUsername(), email);
        ModelAndView modelAndView = new ModelAndView("emailupdate");
        if (updatecheck == 0) {
            modelAndView.addObject("error", "Mail has already registered try giving another mail");
            return modelAndView;
        }
        modelAndView.addObject("error", " mail has been updated successfully");
        return modelAndView;
    }
}
