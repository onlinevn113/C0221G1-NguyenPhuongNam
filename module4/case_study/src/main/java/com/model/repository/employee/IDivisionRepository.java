package com.model.repository.employee;

import com.model.entity.employee.Division;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepository extends PagingAndSortingRepository<Division,Long> {
}
