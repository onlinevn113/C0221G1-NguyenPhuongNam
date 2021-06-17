package com.controller;

import com.model.Student;
import com.model.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("")
    public String home(){
        return "home";
    }
    @PostMapping("/create")
    public ModelAndView result( Student student, Teacher teacher){
        return new ModelAndView("result","student",student).addObject("teacher",teacher);
    }
}
