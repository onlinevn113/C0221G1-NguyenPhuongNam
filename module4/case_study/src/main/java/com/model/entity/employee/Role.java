package com.model.entity.employee;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "id")
    private List<UserRole> userRoleList;

    public Role() {
    }

    public Role(Long id, String name, List<UserRole> userRoleList) {
        this.id = id;
        this.name = name;
        this.userRoleList = userRoleList;
    }

    public Role(String name, List<UserRole> userRoleList) {
        this.name = name;
        this.userRoleList = userRoleList;
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

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }
}
