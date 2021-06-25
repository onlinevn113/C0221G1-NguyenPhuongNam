package com.example.validate_regist_form.model.service;

import com.example.validate_regist_form.model.entity.User;

import java.util.List;

public interface IUserService {
    void save(User user);
    List<User> findAll();
}
