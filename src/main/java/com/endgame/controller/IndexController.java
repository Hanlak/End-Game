package com.endgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("")
@Controller
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView hello(ModelAndView model) {
        model = new ModelAndView("index");
        model.addObject("message", "END-GAME");
        return model;
    }

}
