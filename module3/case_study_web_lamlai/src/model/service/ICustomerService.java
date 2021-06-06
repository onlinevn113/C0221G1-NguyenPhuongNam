package model.service;

import model.bean.Customer;
import model.bean.CustomerType;
import model.bean.Service;
import sun.util.resources.en.CurrencyNames_en_US;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    List<Customer> findByAll();
    List<Customer> findByName(String name);
    Customer findById(int id);
    boolean create(Customer customer) throws SQLException;
    boolean delete(int id);
    boolean edit(int id,Customer customer);
    List<Customer> findByAllUseService();
    List<Service> findByAllServiceUse(int id);
}
