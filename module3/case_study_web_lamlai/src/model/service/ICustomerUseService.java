package model.service;

import model.bean.CustomerUseService;
import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerUseService {
    List<CustomerUseService> findByAll() ;
    List<CustomerUseService> findByName(String name) ;
    CustomerUseService findById(int id);

    boolean edit(int id,CustomerUseService  customerUseService);
    boolean delete(int id);
}
