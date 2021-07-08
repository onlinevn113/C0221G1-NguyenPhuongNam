package com.model.entity.employee;

import javax.persistence.*;
import java.util.List;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "id")
    private List<Employee> employeeList;
    @OneToMany(mappedBy = "id")
    private List<UserRole1> userRole1List;

    public User() {
    }

    public User(Long id, String username, String password, List<Employee> employeeList, List<UserRole1> userRole1List) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.employeeList = employeeList;
        this.userRole1List = userRole1List;
    }

    public User(String username, String password, List<Employee> employeeList, List<UserRole1> userRole1List) {
        this.username = username;
        this.password = password;
        this.employeeList = employeeList;
        this.userRole1List = userRole1List;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<UserRole1> getUserRoleList() {
        return userRole1List;
    }

    public void setUserRoleList(List<UserRole1> userRole1List) {
        this.userRole1List = userRole1List;
    }
}
