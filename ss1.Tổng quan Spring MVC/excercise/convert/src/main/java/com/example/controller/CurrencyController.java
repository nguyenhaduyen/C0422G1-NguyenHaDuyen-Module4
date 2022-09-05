package com.example.controller;

import com.example.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @Autowired
    private IConvertService iConvertService;

    @GetMapping("/")
    public String home() {
        return "/page1";
    }

    @PostMapping("/convertPage2")
    public String convert(@RequestParam double amountOfMoney, @RequestParam double rate, Model model) {
        double result = iConvertService.convert(amountOfMoney, rate);
        model.addAttribute("result", result);
        return "/page2";
    }

}



