package com.example.controller;

import com.example.model.Product;
import com.example.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Map;

@Controller
public class CartController {
    @Autowired
    private ICartService iCartService;

    @GetMapping("/shopping-cart")
    public  String goCart(Model model,
                          @SessionAttribute ("cart") Map<Product, Integer> cart){

        model.addAttribute("cart",cart);

        model.addAttribute("total",
                iCartService.countTotalPayment(cart));

        return "cart";
    }
}
