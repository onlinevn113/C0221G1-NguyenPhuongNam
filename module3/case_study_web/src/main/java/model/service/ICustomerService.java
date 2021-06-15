package model.service;

import model.bean.Customer;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> findByAll();
    List<Customer> findByName(String name);
    Customer findById(int id);
    Map<String, String> create(Customer customer);
    boolean delete(int id);
    boolean edit(int id,Customer customer);
}
