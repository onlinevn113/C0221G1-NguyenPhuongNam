package model.service.impl;

import model.bean.CustomerType;
import model.repository.TypeCustomerRepository;
import model.service.ITypeCustomerService;

import java.util.List;

public class TypeCustomerService implements ITypeCustomerService {
    TypeCustomerRepository typeCustomerRepository=new TypeCustomerRepository();
    @Override
    public List<CustomerType> findAllCustomerType() {
        return typeCustomerRepository.findAllCustomerType();
    }



}
