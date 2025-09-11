package com.example.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springtest.service.MyFibService;

@Controller
public class MyFibController {

    private final MyFibService myFibService;

    @Autowired
    public MyFibController(MyFibService myFibService) {
        this.myFibService = myFibService;
    }

    @GetMapping("/fib")
    public String getFibonacciNumbers(@RequestParam("num") int num, Model model) {
        model.addAttribute("fibNumbers", myFibService.generateFibonacciNumbers(num));
        return "fibonacci";
    }
}