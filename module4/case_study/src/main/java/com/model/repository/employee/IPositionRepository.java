package com.model.repository.employee;

import com.model.entity.employee.Position;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends PagingAndSortingRepository<Position,Long> {
}
