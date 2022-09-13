package com.example.controller;

import com.example.contract.model.AttachFacility;
import com.example.contract.model.Contract;
import com.example.contract.model.ContractDetail;
import com.example.contract.service.IAttachFacilityService;
import com.example.contract.service.IContractDetailService;
import com.example.contract.service.IContractService;
import com.example.customer.model.Customer;
import com.example.customer.model.TypeCustomer;
import com.example.customer.service.ICustomerService;
import com.example.customer.service.ITypeCustomerService;
import com.example.dto.CustomerDto;
import com.example.dto.FacilityDto;
import com.example.employee.model.Employee;
import com.example.employee.service.IDivisionService;
import com.example.employee.service.IEducationDegreeService;
import com.example.employee.service.IEmployeeService;
import com.example.employee.service.IPositionService;
import com.example.facility.model.Facility;
import com.example.facility.model.FacilityType;
import com.example.facility.model.RentType;
import com.example.facility.service.IFacilityService;
import com.example.facility.service.IFacilityTypeService;
import com.example.facility.service.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
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
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IAttachFacilityService iAttachFacilityService;
    @Autowired
    private IContractDetailService iContractDetailService;


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
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("type", iTypeCustomerService.findAll());
        return "customer/add";
    }

    @PostMapping("/customerSave")
    public String saveCustomer(@ModelAttribute("customerDto") @Valid CustomerDto customerDto,
                               BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        customerDto.validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("type", iTypeCustomerService.findAll());
            return "customer/add";
        }
        Customer customer = new Customer();
        TypeCustomer typeCustomer = iTypeCustomerService.findById(Integer.parseInt(customerDto.getTypeCustomer()));
        customer.setTypeCustomer(typeCustomer);
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.add(customer);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/listCustomer";
    }

    @GetMapping("/updateCustomer")
    public String updateCustomer(@RequestParam int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id).get());
        model.addAttribute("type", iTypeCustomerService.findAll());
        return "customer/update";
    }

    @PostMapping("/saveUpdateCustomer")
    public String saveUpdateCustomer(@ModelAttribute("customer") @Valid CustomerDto customerDto,
                                     BindingResult bindingResult,
                                     Model model) {
        customerDto.validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("type", iTypeCustomerService.findAll());
            return "customer/update";
        }
        Customer customer = new Customer();


//        có cần set lại typecustomer trong update k?
        TypeCustomer typeCustomer = iTypeCustomerService.findById(Integer.parseInt(customerDto.getTypeCustomer()));
        customer.setTypeCustomer(typeCustomer);


        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.update(customer);
        return "redirect:/listCustomer";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam int deleteId) {
        iCustomerService.delete(deleteId);
        return "redirect:/listCustomer";
    }

    @GetMapping("/listFacility")
    public String listFacility(Model model, @PageableDefault(size = 5) Pageable pageable, Optional<String> key) {
        String keywordVal = key.orElse("");
        model.addAttribute("facility", iFacilityService.findAllByFacilityNameContaining(keywordVal, pageable));
        model.addAttribute("facilityType", iFacilityTypeService.findAll());
        model.addAttribute("rentType", iRentTypeService.findAll());
        model.addAttribute("keywordVal", keywordVal);
        return "facility/list";
    }

    @GetMapping("/addFacility")
    public String addFacility(Model model) {
        model.addAttribute("facility", new FacilityDto());
        model.addAttribute("facilityTypeNew", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        return "facility/add";
    }

    @PostMapping("/saveAddFacility")
    public String saveAddFacility(@ModelAttribute("facility") @Valid FacilityDto facilityDto,
                                  BindingResult bindingResult,
                                  Model model, RedirectAttributes redirectAttributes) {
        facilityDto.validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityTypeNew", iFacilityTypeService.findAll());
            model.addAttribute("rentTypeList", iRentTypeService.findAll());
            return "facility/add";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);

        FacilityType facilityType = new FacilityType();
        facilityType.setFacilityTypeId(facilityDto.getFacilityType().getFacilityTypeId());
        facility.setFacilityType(facilityType);

        RentType rentType = new RentType();
        rentType.setRentTypeId(facilityDto.getRentType().getRentTypeId());
        facility.setRentType(rentType);

        iFacilityService.add(facility);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
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
    public String saveUpdateFacility(@ModelAttribute("facility") @Valid FacilityDto facilityDto,
                                     BindingResult bindingResult, Model model) {
        facilityDto.validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityTypeNew", iFacilityTypeService.findAll());
            model.addAttribute("rentTypeList", iRentTypeService.findAll());
            return "facility/update";
        }
        Facility facility = new Facility();

        FacilityType facilityType = new FacilityType();
        facilityType.setFacilityTypeId(facilityDto.getFacilityType().getFacilityTypeId());
        facility.setFacilityType(facilityType);

        RentType rentType = new RentType();
        rentType.setRentTypeId(facilityDto.getRentType().getRentTypeId());
        facility.setRentType(rentType);


        BeanUtils.copyProperties(facilityDto, facility);
        iFacilityService.update(facility);
        return "redirect:/listFacility";
    }

    @PostMapping("/deleteFacility")
    public String deleteFacility(@RequestParam int deleteId) {
        iFacilityService.delete(deleteId);
        return "redirect:/listFacility";
    }

    @GetMapping("/listEmployee")
    public String listEmployee(Model model, @PageableDefault(size = 5) Pageable pageable, Optional<String> key) {
//        list
        String keywordVal = key.orElse("");
        model.addAttribute("employeeList", iEmployeeService.findAllByNameOfEmployeeContaining(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);
//        add
        model.addAttribute("employee", new Employee());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("educationList", iEducationDegreeService.findAll());
        model.addAttribute("divisionList", iDivisionService.findAll());
////        update
//        model.addAttribute("employee",iEmployeeService.findById(id));
        return "employee/list";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        iEmployeeService.add(employee);
        return "redirect:/listEmployee";
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam int id) {
        iEmployeeService.delete(id);
        return "redirect:/listEmployee";
    }

    @PostMapping("/saveUpdateEmployee")
    public String saveUpdate(@ModelAttribute Employee employee) {
        iEmployeeService.update(employee);
        return "redirect:/listEmployee";
    }

    @GetMapping("/listContract")
    public String listContract(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("contract", iContractService.showListConTract(pageable));
        model.addAttribute("listAttachFacility", iAttachFacilityService.findAll());

        //addContract
        model.addAttribute("newContract",new Contract());
        model.addAttribute("employeeList",iEmployeeService.employeeList());
        model.addAttribute("customerList",iCustomerService.findAll());
        model.addAttribute("facilityList",iFacilityService.findAll());
        return "contract/list";
    }

    @PostMapping ("/saveContract")
    public String saveContract (@ModelAttribute Contract contract) {
        iContractService.add(contract);
        return "redirect:/listContract";
    }

    @PostMapping("/saveContractDetail")
    public String addContractDetail(int idContract, int attachFacilityId, int quantity) {
        AttachFacility attachFacility = this.iAttachFacilityService.findById(attachFacilityId);
        Contract contract = this.iContractService.findById(idContract);
        if (contract != null && attachFacility != null) {
            ContractDetail contractDetail = new ContractDetail(quantity, contract, attachFacility);
            iContractDetailService.addContractDetail(contractDetail);
        }

        return "redirect:/listContract";
    }
}