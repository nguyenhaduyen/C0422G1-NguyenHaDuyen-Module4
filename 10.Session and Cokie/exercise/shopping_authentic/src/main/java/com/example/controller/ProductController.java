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

@SessionAttributes("cart")

@Controller
public class ProductController {
    @ModelAttribute("cart")
    public Map<Product, Integer> createCart() {
        return new HashMap<>();
    }

    @Autowired
    private IProductService productService;
    @Autowired
    private ICartService iCartService;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("product", productService.findAll());
        return "listProduct";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findId(id).get());
        return "detail";
    }

    @GetMapping("/addCart")
    public String addCart(@RequestParam int id, @SessionAttribute Map<Product, Integer> cart) {
        Product product = productService.findId(id).orElse(null);
        if (product == null) {
            return "error";
        }
        iCartService.addToCart(product,cart);
        return "redirect:/";
    }
    @GetMapping("/cart")
    public String goToCart (@SessionAttribute Map<Product,Integer> cart,Model model) {
        model.addAttribute("cart",cart);
        model.addAttribute("total",iCartService.payment(cart));
        return "cart";
    }
    @GetMapping("/changeQuantity")
    public String changeQuantity (@RequestParam int id,String operand, @SessionAttribute Map<Product,Integer> cart) {
        Product product = productService.findId(id).orElse(null);
        if (product == null) {
            return "error";
        }
        iCartService.changeQuantity(product,cart,operand);
        return "redirect:/cart";
    }
    @GetMapping ("/deleteProduct")
    public String delete (@RequestParam int id,@SessionAttribute Map<Product,Integer> cart) {
        Product product = productService.findId(id).orElse(null);
        if (product == null) {
            return "error";
        }
        iCartService.delete(product,cart);

        return "redirect:/cart";
    }

}
