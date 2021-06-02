package model.service;

import model.bean.Customer;
import sun.util.resources.en.CurrencyNames_en_US;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    List<Customer> findByAll() ;
    Customer findById(int id);
    boolean create(Customer customer) throws SQLException;
    boolean update(int id,Customer customer) throws SQLException;
    boolean delete(int id) throws SQLException;
}
