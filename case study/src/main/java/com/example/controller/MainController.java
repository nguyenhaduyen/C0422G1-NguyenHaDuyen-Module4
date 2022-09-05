package com.example.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.ICustomerService;
import com.example.customer.service.ITypeCustomerService;
import com.example.facility.model.Facility;
import com.example.facility.service.IFacilityService;
import com.example.facility.service.IFacilityTypeService;
import com.example.facility.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ITypeCustomerService iTypeCustomerService;
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/listCustomer")
    public String listCustomer(Model model, @PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> key) {
        String keywordVal = key.orElse("");
        model.addAttribute("customer", iCustomerService.findAllByCustomerNameContaining(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);
        return "customer/list";
    }

    @GetMapping("/customerAdd")
    public String customerAdd(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("type", iTypeCustomerService.findAll());
        return "customer/add";
    }

    @PostMapping("/customerSave")
    public String saveCustomer(@ModelAttribute Customer customer) {
        iCustomerService.add(customer);
        return "redirect:/listCustomer";
    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id).get());
        model.addAttribute("type", iTypeCustomerService.findAll());
        return "customer/update";
    }

    @PostMapping("/saveUpdateCustomer")
    public String saveUpdateCustomer(@ModelAttribute Customer customer) {
        iCustomerService.update(customer);
        return "redirect:/listCustomer";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam int deleteId) {
        iCustomerService.delete(deleteId);
        return "redirect:/listCustomer";
    }

    @GetMapping("/listFacility")
    public String listFacility(Model model) {
        model.addAttribute("facility", iFacilityService.findAll());
        model.addAttribute("facilityType", iFacilityTypeService.findAll());
        model.addAttribute("rentType", iRentTypeService.findAll());
        return "facility/list";
    }

    @GetMapping("/addFacility")
    public String addFacility(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("facilityTypeNew", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        return "facility/add";
    }

    @PostMapping("/saveAddFacility")
    public String saveAddFacility(@ModelAttribute("facility") Facility facility) {
        iFacilityService.add(facility);
        return "redirect:/listFacility";
    }

    @GetMapping("/updateFacility")
    public String updateFacility(@RequestParam int id, Model model) {
        model.addAttribute("facility", iFacilityService.findId(id).get());
        model.addAttribute("facilityTypeNew", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        return "facility/update";
    }

    @PostMapping("/saveUpdateFacility")
    public String saveUpdateFacility(@ModelAttribute Facility facility) {
        iFacilityService.update(facility);
        return "redirect:/listFacility";
    }

    @GetMapping("/listEmployee")
    public String listEmployee() {
        return "employee/list";
    }

    @GetMapping("/addEmployee")
    public String addEmployee() {
        return "employee/add";
    }

    @GetMapping("/listContract")
    public String listContract() {
        return "contract/list";
    }
}
