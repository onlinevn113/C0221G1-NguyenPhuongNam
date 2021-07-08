package com.model.repository.employee;


import com.model.entity.employee.AppUser;
import com.model.entity.employee.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole>  findByAppUser(AppUser appUser);
}
