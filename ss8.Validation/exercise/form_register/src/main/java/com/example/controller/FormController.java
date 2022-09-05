package com.example.controller;

import com.example.dto.FormDto;
import com.example.model.Form;
import com.example.service.IFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class FormController {
    @Autowired
    private IFormService iFormService;

    @GetMapping("/")
    public String list(@PageableDefault(size = 3) Pageable pageable, @RequestParam Optional<String> key, Model model) {
        String keywordVal = key.orElse("");
        model.addAttribute("formList", iFormService.findAllByFirstNameContaining(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("formDto", new FormDto());
        return "create";
    }

    @PostMapping("/saveCreate")
    public String saveCreate(@ModelAttribute("formDto") @Valid FormDto formDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new FormDto().validate(formDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("formDto", formDto);
            return "create";
        }
        Form form = new Form();
        BeanUtils.copyProperties(formDto, form);
        iFormService.create(form);
        redirectAttributes.addFlashAttribute("mess", "register successfully");
        return "redirect:/";
    }
}
