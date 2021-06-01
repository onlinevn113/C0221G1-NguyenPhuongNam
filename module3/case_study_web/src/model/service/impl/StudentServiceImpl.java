package model.service.impl;

import model.bean.Customer;
import model.service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements ICustomerService {
    @Override
    public List<Customer> findByAll() {
        return null;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void create(Customer customer) throws SQLException {

    }


    @Override
    public boolean update(int id, Customer customer) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
