package com.model.entity.customer;

import com.model.entity.contract.Contract;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;


@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private   String code;
    @ManyToOne()

    @JoinColumn(nullable = false)
    private CustomerType customerType;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String birthday;
    @Column(nullable = false)
    private Byte gender;
    @Column(nullable = false)
    private String idCard;
    @Column(nullable = false)
    private String phone;
    private String email;
    private String address;
    private boolean flag;
    @OneToMany(mappedBy = "id")
    private List<Contract> contractList;










    public  String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
