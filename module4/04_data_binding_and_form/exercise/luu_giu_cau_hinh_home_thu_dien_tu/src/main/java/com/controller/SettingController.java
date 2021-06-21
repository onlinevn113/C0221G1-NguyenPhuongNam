package com.controller;

import com.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
    @GetMapping({"","/setting"})
    public String home(Model model) {
        model.addAttribute("setting", new Setting());
        return "home";
    }

    @PostMapping("/update")
    public ModelAndView result(@ModelAttribute("setting") Setting setting) {
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("setting", setting);
        return modelAndView;
    }
}
