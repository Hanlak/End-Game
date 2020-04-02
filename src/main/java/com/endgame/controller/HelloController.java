package com.endgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("")
@Controller
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello(ModelMap model) {
        model.addAttribute("message", "Hi This is sample");
        return "hello";

    }

}
