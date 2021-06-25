package com.example.validate_regist_form.model.repository;

import com.example.validate_regist_form.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
