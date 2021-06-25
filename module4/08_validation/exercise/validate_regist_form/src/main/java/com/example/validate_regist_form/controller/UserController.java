package com.example.validate_regist_form.controller;

import com.example.validate_regist_form.model.dto.UserDto;
import com.example.validate_regist_form.model.entity.User;
import com.example.validate_regist_form.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping({"", "/user"})
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping(value = "/create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("create", "userDto", new UserDto());
    }

    @PostMapping(value = "/create")
    public ModelAndView saveUser(@ModelAttribute @Valid UserDto userDto, BindingResult bindingResult) {
        new UserDto().validate(userDto,bindingResult);
        if (bindingResult.hasErrors()) {
            return new ModelAndView("create").addObject("msg","Create is fail something wrong!!");
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        iUserService.save(user);
        return new ModelAndView("create", "msg", "Create is success");
    }

    @GetMapping(value = "")
    public ModelAndView showListUser() {
        return new ModelAndView("list", "userList", iUserService.findAll());
    }
}
