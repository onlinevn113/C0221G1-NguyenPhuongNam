package com.controller;

import com.model.dto.CustomerDto;
import com.model.entity.customer.Customer;
import com.model.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @GetMapping({"","/search"})
    public ModelAndView showList(@RequestParam("search") Optional<String> search,@RequestParam("birthday") Optional<String> birthday,@RequestParam("idCard") Optional<String> idCard, @PageableDefault(value = 2) Pageable pageable){
        Page<Customer> customerPage=customerService.findAll(search.orElse(""),birthday.orElse(""),idCard.orElse(""),pageable);
        return new ModelAndView("customer/list","customers",customerPage)
                .addObject("search",search.orElse(""))
                .addObject("birthday",birthday.orElse(""))
                .addObject("idCard",idCard.orElse(""));
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        return new ModelAndView("customer/create","customerDto",new CustomerDto()).
                addObject("customerTypes",customerService.findAllCustomerType());
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute @Valid CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, ModelMap map){
        new CustomerDto().validate(customerDto,bindingResult);

        if(bindingResult.hasErrors()){
            for (Customer c:customerService.findAll()){
                if (customerDto.getCode().equals(c.getCode())){
                    return new ModelAndView("customer/create","msg","Something wrong!! Try again").
                            addObject("customerTypes",customerService.findAllCustomerType()).
                            addObject("codeDuplicate","Duplicate code");
                }
            }
            return new ModelAndView("customer/create","msg","Something wrong!! Try again").
                    addObject("customerTypes",customerService.findAllCustomerType());
        }
        for (Customer c:customerService.findAll()){
            if (customerDto.getCode().equals(c.getCode())){
                return new ModelAndView("customer/create","msg","Something wrong!! Try again").
                        addObject("customerTypes",customerService.findAllCustomerType()).
                        addObject("codeDuplicate","Duplicate code");
            }
        }

        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg","Create is successful!!");

        return new ModelAndView("redirect:/customer");
    }
    @GetMapping("/edit/{idc}")
    public ModelAndView showEdit(@PathVariable Long idc){
        if (customerService.findById(idc)==null){
            return new ModelAndView("error-404");
        }
        CustomerDto customerDto=new CustomerDto();
        BeanUtils.copyProperties(customerService.findById(idc),customerDto);

        return new ModelAndView("customer/edit","customerDto",customerDto).
                addObject("customerTypes",customerService.findAllCustomerType());
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute @Valid CustomerDto customerDto,BindingResult bindingResult,RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()){
            for (Customer c:customerService.findAll()){
                if (customerDto.getCode().equals(c.getCode())){
                    return new ModelAndView("customer/edit","msg","Something wrong!! Try again").
                            addObject("customerTypes",customerService.findAllCustomerType()).
                            addObject("codeDuplicate","Duplicate code");
                }
            }
            return new ModelAndView("customer/edit","msg","Something wrong!! Try again").
                    addObject("customerTypes",customerService.findAllCustomerType());
        }
        for (Customer c:customerService.findAll()){
            if (customerDto.getCode().equals(c.getCode())){
                return new ModelAndView("customer/edit","msg","Something wrong!! Try again").
                        addObject("customerTypes",customerService.findAllCustomerType()).
                        addObject("codeDuplicate","Duplicate code");
            }
        }
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg","Edit is successful!!");
        return new ModelAndView("redirect:/customer");
    }
    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam("listId") List<Long> listId, RedirectAttributes redirectAttributes){
        for (Long id: listId) {
            Customer customer=customerService.findById(id);
            if (customer==null){
                return new ModelAndView("error-404");
            }
            customer.setFlag(true);
            customerService.save(customer);
        }
        redirectAttributes.addFlashAttribute("msg","Delete is successful!!");
        return new ModelAndView("redirect:/customer");
    }
}
