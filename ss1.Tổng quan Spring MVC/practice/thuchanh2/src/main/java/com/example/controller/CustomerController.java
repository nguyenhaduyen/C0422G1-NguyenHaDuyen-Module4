package com.example.controller;
import com.example.model.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/customer")
    public String listCustomer(Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customer", customerList);
        return "/customer/list";
    }
}
