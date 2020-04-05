package com.endgame.controller;

import com.endgame.dao.RegisterDao;
import com.endgame.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RegisterController {

    @Autowired
    private RegisterDao registerDao;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    protected ModelAndView register() {
        ModelAndView modelandview = new ModelAndView("register");
        return modelandview;
    }

    @PostMapping("/registerProcess")
    protected ModelAndView registerProcess(@RequestParam("firstname") String fname, @RequestParam("lastname") String lname, @RequestParam("email") String email, @RequestParam("userName") String username, @RequestParam("password") String password) {

        ModelAndView modelandview = new ModelAndView();
        Register register = new Register();

        register.setFirstname(fname);
        register.setLastname(lname);
        register.setUsername(username);
        register.setEmail(email);
        register.setPassword(password);
        int check = registerDao.register(register);
        if (check > 0) {
            modelandview.addObject("msg", "User registration successful.");
        } else {
            modelandview.addObject("msg", "Error- check the console log.");
        }
        modelandview.setViewName("login");
        return modelandview;
    }

}
