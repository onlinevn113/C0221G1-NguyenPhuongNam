package com.controller;

import com.model.dto.ContractDetailDto;
import com.model.dto.ContractDto;
import com.model.dto.CustomerDto;
import com.model.entity.contract.AttachService;
import com.model.entity.contract.Contract;
import com.model.entity.contract.ContractDetail;
import com.model.entity.customer.Customer;
import com.model.entity.employee.Employee;
import com.model.entity.service.Service;
import com.model.service.IContractService;
import com.model.service.ICustomerService;
import com.model.service.IEmployeeService;
import com.model.service.IServiceService;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService contractService;
    @Autowired
    ICustomerService customerService;
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IServiceService serviceService;


    @ModelAttribute("contracts")
    private List<Contract> contracts(){
            return contractService.findAll();
    }

    @ModelAttribute("services")
    private List<Service> services() {
        return serviceService.findAll();
    }

    @ModelAttribute("customers")
    private List<Customer> customers() {
        return customerService.findAll();
    }

    @ModelAttribute("employees")
    private List<Employee> employees() {
        return employeeService.findAll();
    }
    @ModelAttribute("attachServices")
    private List<AttachService> attachServices(){
        return contractService.attachServices();
    }

    @ModelAttribute("contractDetails")
    private List<ContractDetail> contractDetails(){
       return contractService.contractDetails();
    }


    @SneakyThrows
    @GetMapping({"","/search"})
    public ModelAndView showListCustomerUsing(@RequestParam("search") Optional<String> search, @PageableDefault(value = 2) Pageable pageable){
        Page<Contract> contractss=contractService.findAll(search.orElse(""),pageable);
        for (Contract contract :contractss){
            try {
                Date sDate= new SimpleDateFormat("yyyy-MM-dd").parse(contract.getStartDate());
                Date eDate= new SimpleDateFormat("yyyy-MM-dd").parse(contract.getEndDate());
                Double totalMoney=eDate.compareTo(sDate)*contract.getService().getCost();
                for (ContractDetail cd: contract.getContractDetailList()){
                    totalMoney+=cd.getQuantity()*cd.getAttachService().getCost();
                }
                contract.setTotalMoney(totalMoney);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return new ModelAndView("customer_using/list","contractss",contractss).
                addObject("search",search.orElse(""));
    }
    @GetMapping("/edit/{idc}")
    public ModelAndView showEdit(@PathVariable Long idc){
        if (contractService.findById(idc)==null){
            return new ModelAndView("error-404");
        }
        ContractDto contractDto=new ContractDto();
        BeanUtils.copyProperties(contractService.findById(idc),contractDto);

        return new ModelAndView("customer_using/edit","contractDto",contractDto);
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute @Valid ContractDto contractDto,BindingResult bindingResult,RedirectAttributes redirectAttributes){
        new ContractDto().validate(contractDto,bindingResult);
        if (bindingResult.hasErrors()){
            return new ModelAndView("customer_using/edit","msg","Something wrong!! Try again").
                    addObject("customerTypes",customerService.findAllCustomerType());
        }
        Contract contract=new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("msg","Edit is successful!!");
        return new ModelAndView("redirect:/contract");
    }














    @GetMapping("/create-contract")
    public ModelAndView showCreateContract() {
        return new ModelAndView("/contract/create").addObject("contractDto", new ContractDto());
    }

    @GetMapping("/create-contract-detail")
    public ModelAndView showCreateContractDetail() {
        return new ModelAndView("/contract_detail/create","contractDetailDto",new ContractDetailDto());
    }
    @PostMapping("/create-contract")
    public ModelAndView createContract(@ModelAttribute @Valid ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new ContractDto().validate(contractDto,bindingResult);
        if (bindingResult.hasErrors()){
            return new ModelAndView("/contract/create","msg","Something wrong!! Try again");
        }
        Contract contract=new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("msg","Create contract is successfully");
        return new ModelAndView("redirect:/home");
    }
    @PostMapping("/create-contract-detail")
    public ModelAndView createContractDetail(@ModelAttribute @Valid ContractDetailDto contractDetailDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return new ModelAndView("/contract_detail/create","msg","Something wrong!! Try again");
        }
        ContractDetail contractDetail=new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);
        contractService.save(contractDetail);
        redirectAttributes.addFlashAttribute("msg","Create contract detail is successfully");
        return new ModelAndView("redirect:/home");
    }






}
