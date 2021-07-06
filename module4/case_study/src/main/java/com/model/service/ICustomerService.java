package com.model.service;

import com.model.entity.contract.Contract;
import com.model.entity.contract.ContractDetail;
import com.model.entity.customer.Customer;
import com.model.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    List<CustomerType> findAllCustomerType();
    List<Customer> findAll();

}
