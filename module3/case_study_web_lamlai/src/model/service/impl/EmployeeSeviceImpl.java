package model.service.impl;

import model.bean.Employee;
import model.repository.EmployeeRepository;
import model.service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeSeviceImpl implements IEmployeeService {
    EmployeeRepository employeeRepository=new EmployeeRepository();
    @Override
    public List<Employee> findByAll() {
        return employeeRepository.findByAll();
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public boolean create(Employee employee) throws SQLException {
        return employeeRepository.create(employee);
    }

    @Override
    public boolean edit(int id, Employee employee) {
        return employeeRepository.edit(id,employee);
    }

    @Override
    public boolean delete(int id) {
        return employeeRepository.delete(id);
    }
}
