package com.endgame.controller;

import com.endgame.dao.LoginDao;
import com.endgame.model.Login;
import com.endgame.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    LoginDao dao;

    /*
     * Add user in model attribute
     */
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    protected ModelAndView login() {
        ModelAndView modelandview = new ModelAndView("login");
        return modelandview;
    }

    @PostMapping("/loginProcess")
    protected ModelAndView loginProcess(@ModelAttribute("user") User user) {
        ModelAndView modelandview;
        Login login = dao.getUserById(user.getUsername());
        if (login != null) {
            if (user.getUsername().equals(login.getUsername())
                    && user.getPassword().equals(login.getPassword())) {
                modelandview = new ModelAndView("questions");
            } else {
                modelandview = new ModelAndView("login", "msg", "Invalid credentials");
            }
        } else modelandview = new ModelAndView("login", "msg", "user not existed");
        return modelandview;
    }
}
