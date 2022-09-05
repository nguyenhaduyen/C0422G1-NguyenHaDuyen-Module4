package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "/hello";
    }
}
