package model.service.impl;

import model.bean.Customer;
import model.repository.CustomerRepository;
import model.service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findByAll() {
        return customerRepository.findByAll();
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }
    @Override
    public boolean create(Customer customer) throws SQLException {
        return customerRepository.createCustomer(customer);
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public boolean edit(int id, Customer customer) {
        return customerRepository.edit(id,customer);
    }


}