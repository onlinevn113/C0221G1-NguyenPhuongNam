package com.model.entity.employee;

import lombok.Data;
import javax.persistence.*;


@Entity
public class UserRole1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Role role;

    @ManyToOne
    private User user;

    public UserRole1() {
    }

    public UserRole1(Long id, Role role, User user) {
        this.id = id;
        this.role = role;
        this.user = user;
    }

    public UserRole1(Role role, User user) {
        this.role = role;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
