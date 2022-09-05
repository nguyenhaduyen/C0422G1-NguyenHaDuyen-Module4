package com.example.controller;

import com.example.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    @Autowired
    private ICalculateService iCalculateService;

    @GetMapping("/")
    public String home() {
        return "/index";
    }

    @GetMapping("/result")
    public String result(@RequestParam String operator1, @RequestParam String operator2, @RequestParam String operand, Model model) {
        model.addAttribute("result", iCalculateService.calculate(operator1, operator2, operand));
        return "/index";
    }
}
