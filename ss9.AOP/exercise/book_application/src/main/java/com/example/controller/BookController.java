package com.example.controller;

import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @Autowired
    private IBookService iBookService;
    @GetMapping("/")
    public String list (Model model) {
        model.addAttribute("book",iBookService.findAll());
        return "list";
    }
}
