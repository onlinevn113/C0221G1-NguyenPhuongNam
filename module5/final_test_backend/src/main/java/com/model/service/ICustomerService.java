package com.model.service;

import com.model.entity.Customer;
import com.model.entity.CustomerType;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer>{
    List<CustomerType> findAllCustomerType();
    List<Customer> findAll();
}
