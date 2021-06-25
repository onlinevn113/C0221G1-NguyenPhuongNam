package com.example.validate_regist_form.model.service.impl;

import com.example.validate_regist_form.model.entity.User;
import com.example.validate_regist_form.model.repository.UserRepository;
import com.example.validate_regist_form.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
    @Override
    public List<User> findAll() {
       return userRepository.findAll();
    }
}
