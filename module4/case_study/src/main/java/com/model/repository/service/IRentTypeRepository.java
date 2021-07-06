package com.model.repository.service;

import com.model.entity.service.RentType;
import com.model.entity.service.ServiceType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentTypeRepository extends PagingAndSortingRepository<RentType,Long> {
}
