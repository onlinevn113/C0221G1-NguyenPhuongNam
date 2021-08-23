package com.model.service.impl;

import com.model.entity.Customer;
import com.model.entity.CustomerType;
import com.model.service.ICustomerService;
import com.repository.ICustomerRepository;
import com.repository.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAllCustomerType() {
        return (List<CustomerType>) customerTypeRepository.findAll();
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer o) {
        customerRepository.save(o);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
