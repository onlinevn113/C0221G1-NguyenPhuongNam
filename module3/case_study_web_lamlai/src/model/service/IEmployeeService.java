package model.service;

import model.bean.Customer;
import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    List<Employee> findByAll() ;
    List<Employee> findByName(String name) ;
    Employee findById(int id);
    boolean create(Employee employee) throws SQLException;
    boolean edit(int id,Employee employee);
    boolean delete(int id);

}
