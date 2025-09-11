package com.example.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FibUsageController {

    @GetMapping("/fib/")
    public String fibUsage(Model model) {
        return "usage";
    }
}