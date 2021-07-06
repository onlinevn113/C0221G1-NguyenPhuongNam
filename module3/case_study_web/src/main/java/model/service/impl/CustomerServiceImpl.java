package model.service.impl;


import model.bean.Customer;
import model.bean.CustomerType;
import model.bean.Service;
import model.repository.CustomerRepository;
import model.service.ICustomerService;
import model.service.common.Regex;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements  ICustomerService {
    CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findByAll() {
        return customerRepository.findByAll();
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }


    @Override
    public Map<String,String> create(Customer customer){
        Regex regex=new Regex();
        Map<String,String> mapMsg= new HashMap<>();
        boolean flag=true;

        if ("".equals(customer.getName())){
            mapMsg.put("name","Please input name");
            flag=false;
        }else if(!customer.getName().matches(regex.NAME)) {
            mapMsg.put("name","Please input invalid format");
            flag=false;
        }

        if ("".equals(customer.getDateOfBirth())){
            mapMsg.put("dateOfBirth","Please input date of birth");
            flag=false;
        }else if(!customer.getDateOfBirth().matches(regex.DATE)) {
            mapMsg.put("dateOfBirth","Please input invalid format");
            flag=false;
        }

        if ("".equals(customer.getIdCard())){
            mapMsg.put("idCard","Please input id card");
            flag=false;
        }else if(!customer.getIdCard().matches(regex.IDCARD)) {
            mapMsg.put("idCard","Please input invalid format");
            flag=false;
        }

        if ("".equals(customer.getPhoneNumber())){
            mapMsg.put("phoneNumber","Please input phone number");
            flag=false;
        }else if(!customer.getPhoneNumber().matches(regex.PHONENUMBER)) {
            mapMsg.put("phoneNumber","Please input invalid format");
            flag=false;
        }

        if ("".equals(customer.getEmail())){
            mapMsg.put("email","Please input email");
            flag=false;
        }else if(!customer.getEmail().matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            mapMsg.put("email","Please input invalid format");
            flag=false;
        }
        if ("".equals(customer.getAddress())){
            flag=false;
            mapMsg.put("address","Please input address");
        }

        if (flag) {
            customerRepository.createCustomer(customer);
        }
        return mapMsg;
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public boolean edit(int id, Customer customer) {
        return customerRepository.edit(id,customer);
    }

}
