package com.model.entity.service;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity

public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "id")
    private List<Service> serviceList;

    public ServiceType() {
    }

    public ServiceType(Long id, String name, List<Service> serviceList) {
        this.id = id;
        this.name = name;
        this.serviceList = serviceList;
    }

    public ServiceType(String name, List<Service> serviceList) {
        this.name = name;
        this.serviceList = serviceList;
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

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
