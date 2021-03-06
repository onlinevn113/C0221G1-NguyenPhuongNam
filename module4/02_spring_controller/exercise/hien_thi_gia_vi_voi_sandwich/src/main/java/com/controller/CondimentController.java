package com.controller;

import com.service.ICondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CondimentController {
    @Autowired
    ICondimentService iCondimentService;
    @GetMapping(value = "")
    public String home(){
        return "home";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ModelAndView save(@RequestParam("condiment") String[] condiment) {
        return new ModelAndView("home","condiment",iCondimentService.a(condiment));
    }
}
