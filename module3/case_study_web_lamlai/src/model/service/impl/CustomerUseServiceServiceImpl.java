package model.service.impl;

import model.bean.CustomerUseService;
import model.repository.CustomerUseServiceRepository;
import model.service.ICustomerUseService;

import java.util.List;

public class CustomerUseServiceServiceImpl implements ICustomerUseService {
    CustomerUseServiceRepository customerUseServiceRepository=new CustomerUseServiceRepository();
    @Override
    public List<CustomerUseService> findByAll() {
        return customerUseServiceRepository.findByAll();
    }

    @Override
    public List<CustomerUseService> findByName(String name) {
        return customerUseServiceRepository.findByName(name);
    }

    @Override
    public CustomerUseService findById(int id) {
        return customerUseServiceRepository.findById(id);
    }

    @Override
    public boolean edit(int id, CustomerUseService customerUseService) {
        return customerUseServiceRepository.edit(id,customerUseService);
    }

    @Override
    public boolean delete(int id) {
        return customerUseServiceRepository.delete(id);
    }
}
