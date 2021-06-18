package com.controller;

import com.model.bean.Student;
import com.model.bean.Teacher;
import com.model.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    IStudentService iStudentService;
    @GetMapping("")
    public String home(){
        return "home";
    }
    @PostMapping("/create")
    public ModelAndView result(@ModelAttribute Student student){
        return new ModelAndView("result","student",iStudentService.save(student));
    }

}
