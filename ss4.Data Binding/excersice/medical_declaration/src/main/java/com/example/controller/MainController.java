package com.example.controller;

import com.example.model.*;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private IDateService iDateService;
    @Autowired
    private IGenderService iGenderService;
    @Autowired
    private INationService iNationService;
    @Autowired
    private IVehicleService iVehicleService;
    @Autowired
    private IYearOfBirthService iYearOfBirthService;
    @Autowired
    private IPaperDeclarationService iPaperDeclarationService;

    @GetMapping("/")
    public String list(Model model) {
        List<PaperDeclaration> paperDeclarationList = iPaperDeclarationService.show();
        model.addAttribute("paperList", paperDeclarationList);
        return "show";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        model.addAttribute("paperDeclaration", iPaperDeclarationService.findId(id));
        return "details";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<String> yearOfBirthList = iYearOfBirthService.findAll();
        List<Gender> genderList = iGenderService.findAll();
        List<Nation> nationList = iNationService.findAll();
        List<Vehicle> vehicleList = iVehicleService.findAll();
        List<String> dateList = iDateService.findDateAll();
        List<String> monthList = iDateService.findMonthAll();
        List<String> yearList = iDateService.findYearAll();
        model.addAttribute("paperDeclaration", new PaperDeclaration());
        model.addAttribute("genderList", genderList);
        model.addAttribute("yearOfBirthList", yearOfBirthList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("vehicleList", vehicleList);
        model.addAttribute("dateList", dateList);
        model.addAttribute("monthList", monthList);
        model.addAttribute("yearList", yearList);
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute PaperDeclaration paperDeclaration, Model model, RedirectAttributes redirectAttributes) {
        iPaperDeclarationService.save(paperDeclaration);
        model.addAttribute("paperList", iPaperDeclarationService.show());
        redirectAttributes.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id, Model model) {
        PaperDeclaration paperDeclaration1 = iPaperDeclarationService.findId(id);
        List<String> yearOfBirthList = iYearOfBirthService.findAll();
        List<Gender> genderList = iGenderService.findAll();
        List<Nation> nationList = iNationService.findAll();
        List<Vehicle> vehicleList = iVehicleService.findAll();
        List<String> dateList = iDateService.findDateAll();
        List<String> monthList = iDateService.findMonthAll();
        List<String> yearList = iDateService.findYearAll();
        model.addAttribute("paperDeclaration", new PaperDeclaration());
        model.addAttribute("paperDeclaration1", paperDeclaration1);
        model.addAttribute("genderList", genderList);
        model.addAttribute("yearOfBirthList", yearOfBirthList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("vehicleList", vehicleList);
        model.addAttribute("dateList", dateList);
        model.addAttribute("monthList", monthList);
        model.addAttribute("yearList", yearList);
        return "update";
    }

    @PostMapping("/submit")
    public String saveEdit(@ModelAttribute PaperDeclaration paperDeclaration, RedirectAttributes redirectAttributes) {
        iPaperDeclarationService.edit(paperDeclaration);
        redirectAttributes.addFlashAttribute("mess", "chỉnh sửa thành công");
        return "redirect:/";
    }
}
