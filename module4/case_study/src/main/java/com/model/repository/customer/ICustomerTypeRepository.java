package com.model.repository.customer;

import com.model.entity.customer.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepository extends PagingAndSortingRepository<CustomerType,Long> {
}
