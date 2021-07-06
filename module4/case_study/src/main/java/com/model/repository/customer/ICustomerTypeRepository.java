package com.model.repository.customer;

import com.model.entity.customer.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerTypeRepository extends PagingAndSortingRepository<CustomerType,Long> {
}
