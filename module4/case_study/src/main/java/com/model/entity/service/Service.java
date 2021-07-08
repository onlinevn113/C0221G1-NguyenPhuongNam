package com.model.entity.service;

import com.model.entity.contract.Contract;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String code;
    private String name;
    private Integer area;
    @Column(nullable = false)
    private Double cost;
    private Integer maxPeople;
    @ManyToOne()
    @JoinColumn(nullable = false)
    private RentType rentType;
    @ManyToOne()
    @JoinColumn(nullable = false)
    private ServiceType serviceType;

    private String standardRoom;
    private String description;
    private Double poolArea;
    private Integer floors;



    @OneToMany(mappedBy = "id")
    private List<Contract> contractList;
    private boolean flag;

















    public Service() {
    }

    public Service(Long id, String code, String name, Integer area, Double cost, Integer maxPeople, RentType rentType, ServiceType serviceType, String standardRoom, String description, Double poolArea, Integer floors, List<Contract> contractList, boolean flag) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.floors = floors;
        this.contractList = contractList;
        this.flag = flag;
    }

    public Service(String code, String name, Integer area, Double cost, Integer maxPeople, RentType rentType, ServiceType serviceType, String standardRoom, String description, Double poolArea, Integer floors, List<Contract> contractList, boolean flag) {
        this.code = code;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.floors = floors;
        this.contractList = contractList;
        this.flag = flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
