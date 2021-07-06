package com.model.repository.employee;

import com.model.entity.customer.Customer;
import com.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    @Query(value = "select * from employee where name like %?1% && flag = 0 order by id desc ",nativeQuery = true)
    Page<Employee> findAllEmployee(String name, Pageable pageable);
}
