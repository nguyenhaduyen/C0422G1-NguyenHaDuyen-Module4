package com.example.controller;

import com.example.model.Library;
import com.example.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibraryController {
    @Autowired
    private ILibraryService iLibraryService;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("library", iLibraryService.findAll());
        return "list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        model.addAttribute("library", iLibraryService.findById(id).get());
        return "detail";
    }

    @GetMapping("/borrow")
    public String borrow(@RequestParam int id, Model model) throws Exception {
        Library library = iLibraryService.findById(id).get();
        if (library == null) {
            throw new Exception();
        }
        if (library.getStatus() == 0) {
            model.addAttribute("msg", "hết sách");
            model.addAttribute("library", library);
            return "detail";
        }
        library.setStatus(library.getStatus() - 1);
        iLibraryService.update(library);
        model.addAttribute("library", library);
        model.addAttribute("msg", "đã thuê thành công");
        return "detail";

    }

    @GetMapping("/pay")
    public String pay() {
        return "pay";
    }

    @PostMapping("/paySave")
    public String saveUpdate(@RequestParam int id, Model model) throws Exception {
        Library library = iLibraryService.findById(id).get();
        if (library == null) {
            throw new Exception();
        }
        if (library.getStatus() == library.getNumberOfBook()) {
            model.addAttribute("msg", "số lượng sách đã đủ trong thư viện");
            return "pay";
        }
        library.setStatus(library.getStatus() + 1);
        iLibraryService.update(library);
        model.addAttribute("msg", "trả sách thành công");
        return "pay";
    }

    @ExceptionHandler(value = Exception.class)
    public String error() {
        return "error";
    }

}

