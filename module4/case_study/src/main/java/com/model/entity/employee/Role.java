package com.model.entity.employee;

import javax.persistence.*;
import java.util.List;


@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "id")
    private List<UserRole1> userRole1List;

    public Role() {
    }

    public Role(Long id, String name, List<UserRole1> userRole1List) {
        this.id = id;
        this.name = name;
        this.userRole1List = userRole1List;
    }

    public Role(String name, List<UserRole1> userRole1List) {
        this.name = name;
        this.userRole1List = userRole1List;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserRole1> getUserRoleList() {
        return userRole1List;
    }

    public void setUserRoleList(List<UserRole1> userRole1List) {
        this.userRole1List = userRole1List;
    }
}
