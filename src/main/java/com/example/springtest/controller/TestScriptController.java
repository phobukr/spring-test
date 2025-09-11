package com.example.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestScriptController {

    @RequestMapping("/test_script.html")
    public ModelAndView testScript() {
        return new ModelAndView("test_script");
    }
}