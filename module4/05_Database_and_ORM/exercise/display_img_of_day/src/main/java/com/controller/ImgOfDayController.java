package com.controller;

import com.model.entity.ImgOfDay;
import com.model.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"imgOfDay",""})
public class ImgOfDayController {
    @Autowired
    private ImgService imgService;

    @GetMapping("")
    public ModelAndView showHome() {
        return new ModelAndView("home", "comment",new ImgOfDay())
                .addObject("listComment",imgService.showAll());
    }
    @PostMapping("/comment")
    public String comment(@ModelAttribute ImgOfDay imgOfDay){
        imgService.addComment(imgOfDay);
        return "redirect:/imgOfDay/";
    }
    @GetMapping("/like")
    public String like(@RequestParam int id){
        imgService.addLike(id);
        return "redirect:/imgOfDay/";
    }


}
