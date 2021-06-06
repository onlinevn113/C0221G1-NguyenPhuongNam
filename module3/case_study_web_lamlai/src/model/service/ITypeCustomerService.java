package model.service;

import model.bean.Customer;
import model.bean.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface ITypeCustomerService {
    List<CustomerType> findAllCustomerType() ;
}
