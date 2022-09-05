package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping(value = {"/search","/"})
    public String list(String name,Model model) {
        model.addAttribute("productList", iProductService.findAll(name));
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/saveCreate")
    public String saveCreate(@ModelAttribute Product product) {
        iProductService.create(product);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        iProductService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute Product product) {
        iProductService.update(product);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String details(int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "detail";
    }
}
