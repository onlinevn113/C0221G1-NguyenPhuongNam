package com.model.repository.employee;

import com.model.entity.employee.UserRole1;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRoleResitory extends PagingAndSortingRepository<UserRole1,Long> {
}
