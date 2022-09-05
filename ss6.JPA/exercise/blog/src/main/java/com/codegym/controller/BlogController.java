package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("blogList", iBlogService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/saveCreate")
    public String saveCreate(@ModelAttribute Blog blog) {
        iBlogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        iBlogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam int id, Model model) {
        Optional<Blog> blog = iBlogService.findId(id);
        model.addAttribute("blog", blog.get());
        return "update";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute Blog blog) {
        iBlogService.update(blog);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        Optional<Blog> blog = iBlogService.findId(id);
        model.addAttribute("blog", blog.get());
        return "detail";
    }
}
