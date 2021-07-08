package com.controller;


import com.model.dto.EmployeeDto;
import com.model.entity.employee.Employee;
import com.model.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @GetMapping({"","/search"})
    public ModelAndView showList(@RequestParam("search") Optional<String> search, @PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView("employee/list","employees",employeeService.findAll(search.orElse(""),pageable)).
                addObject("search",search.orElse(""));
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        return new ModelAndView("employee/create","employeeDto",new EmployeeDto()).
                addObject("educationDegrees",employeeService.educationDegreeList()).
                addObject("divisions",employeeService.divisionList()).
                addObject("positions",employeeService.positionList());
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute @Valid EmployeeDto employeeDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new EmployeeDto().validate(employeeDto,bindingResult);
        if(bindingResult.hasErrors()){
            return new ModelAndView("employee/create","msg","Something wrong!! Try again").
                    addObject("educationDegrees",employeeService.educationDegreeList()).
                    addObject("divisions",employeeService.divisionList()).
                    addObject("positions",employeeService.positionList());
        }
        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg","Create is successful!!");
        return new ModelAndView("redirect:/employee");

    }
    @GetMapping("/edit/{idc}")
    public ModelAndView showEdit(@PathVariable Long idc){
        if (employeeService.findById(idc)==null){
            return new ModelAndView("error-404");
        }
        EmployeeDto employeeDto=new EmployeeDto();
        BeanUtils.copyProperties(employeeService.findById(idc),employeeDto);

        return new ModelAndView("employee/edit","employeeDto",employeeDto).
                addObject("educationDegrees",employeeService.educationDegreeList()).
                addObject("divisions",employeeService.divisionList()).
                addObject("positions",employeeService.positionList());
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute @Valid EmployeeDto employeeDto,BindingResult bindingResult,RedirectAttributes redirectAttributes){
        new EmployeeDto().validate(employeeDto,bindingResult);
        if (bindingResult.hasErrors()){
            return new ModelAndView("employee/create","msg","Something wrong!! <br> Try again").
                    addObject("educationDegrees",employeeService.educationDegreeList()).
                    addObject("divisions",employeeService.divisionList()).
                    addObject("positions",employeeService.positionList());
        }

        Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg","Edit is successful!!");
        return new ModelAndView("redirect:/employee");
    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam Long id,RedirectAttributes redirectAttributes){
        Employee employee=employeeService.findById(id);
        if (employee==null){
            return new ModelAndView("error-404");
        }
        employee.setFlag(true);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg","Delete is successful!!");
        return new ModelAndView("redirect:/employee");
    }
}
