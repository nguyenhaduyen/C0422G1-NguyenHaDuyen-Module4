package com.example.controller;

import com.example.model.Condiment;
import com.example.service.ICondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CondimentController {

    @Autowired
    private ICondimentService iCondimentService;

    @GetMapping("/")
    public String home(Model model) {
        List<Condiment> condimentList = iCondimentService.findAll();
        model.addAttribute("condimentList", condimentList);
        return "index";
    }

    @GetMapping("/result")
    public String result(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("condimentList", iCondimentService.findAll());
        model.addAttribute("condiment", condiment);
        return "index";
    }
}
