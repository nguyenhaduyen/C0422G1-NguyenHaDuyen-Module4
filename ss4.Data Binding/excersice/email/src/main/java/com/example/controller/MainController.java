package com.example.controller;

import com.example.model.FormEmail;
import com.example.model.Language;
import com.example.model.PageSize;
import com.example.service.IFormEmailService;
import com.example.service.ILanguageService;
import com.example.service.IPageSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ILanguageService iLanguageService;
    @Autowired
    private IPageSizeService iPageSizeService;
    @Autowired
    private IFormEmailService iFormEmailService;

    @GetMapping("/")
    public String create(Model model) {
        List<Language> languageList = iLanguageService.findAll();
        List<PageSize> pageSizeList = iPageSizeService.findAll();
        model.addAttribute("form", new FormEmail());
        model.addAttribute("languageList", languageList);
        model.addAttribute("pageSizeList", pageSizeList);
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute FormEmail formEmail, Model model) {
        iFormEmailService.save(formEmail);
        model.addAttribute("formEmail", iFormEmailService.showEmail());
        return "showForm";
    }
}
