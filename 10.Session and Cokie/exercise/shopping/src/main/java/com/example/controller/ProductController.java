package com.example.controller;

import com.example.model.Product;
import com.example.service.ICartService;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SessionAttributes (value = "cart")
@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICartService iCartService;

    @ModelAttribute (value = "cart")
    public Map<Product, Integer> setupCart() {
        return new HashMap<>();
    }

    @GetMapping("/addCart")
    public String addCart (@RequestParam int id,
                           @SessionAttribute Map<Product, Integer> cart) {
        Product product = iProductService.findId(id).get();
        iCartService.addProduct(cart,product);
        return "redirect:/";
    }

    @GetMapping("/")
    public String list(Model model) {
       model.addAttribute("product",iProductService.findAll());
       return "listProduct";
    }
    @GetMapping("/detail")
    public String detail (@RequestParam int id,Model model) {
        model.addAttribute("product",iProductService.findId(id).get());
        return "detail";
    }

}
