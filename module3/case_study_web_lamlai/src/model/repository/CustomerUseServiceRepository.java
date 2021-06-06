package model.repository;

import model.bean.CustomerUseService;
import model.bean.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUseServiceRepository {
    BaseRepository baseRepository = new BaseRepository();

    public List<CustomerUseService> findByAll() {
        Connection connection = baseRepository.connectDataBase();
        List<CustomerUseService> customerUseServices = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select c.customer_id,customer_name,customer_birthday,sv.service_id,service_name,\n" +
                    "ct.contract_id,attach_service_name\n" +
                    "from customer c\n" +
                    "join contract ct on c.customer_id=ct.customer_id\n" +
                    "join service sv on ct.service_id=sv.service_id\n" +
                    "join contract_detail cd on cd.contract_id=ct.contract_id\n" +
                    "join attach_service ats on cd.attach_service_id=ats.attach_service_id\n" +
                    ";");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("c.customer_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int serviceId=resultSet.getInt("sv.service_id");
                String serviceName = resultSet.getString("service_name");
                int contractId = resultSet.getInt("ct.contract_id");
                String attachService = resultSet.getString("attach_service_name");
                customerUseServices.add(new CustomerUseService(customerId, customerName, customerBirthday, serviceId,serviceName, contractId, attachService));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerUseServices;
    }

    public List<CustomerUseService> findByName(String name1) {
        List<CustomerUseService> customerUseServices = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("select c.customer_id,customer_name,customer_birthday,sv.service_id,service_name,\n" +
                    "ct.contract_id,attach_service_name\n" +
                    "from customer c\n" +
                    "join contract ct on c.customer_id=ct.customer_id\n" +
                    "join service sv on ct.service_id=sv.service_id\n" +
                    "join contract_detail cd on cd.contract_id=ct.contract_id\n" +
                    "join attach_service ats on cd.attach_service_id=ats.attach_service_id\n" +
                    "where customer_name like ?\n" +
                    ";");
            statement.setString(1, "%" + name1 + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("c.customer_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int serviceId=resultSet.getInt("sv.service_id");
                String serviceName = resultSet.getString("service_name");
                int contractId = resultSet.getInt("ct.contract_id");
                String attachService = resultSet.getString("attach_service_name");
                customerUseServices.add(new CustomerUseService(customerId, customerName, customerBirthday, serviceId,serviceName, contractId, attachService));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerUseServices;
    }

    public CustomerUseService findById(int id) {
     CustomerUseService customerUseService=null;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                
                      }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
     return customerUseService;
    }

    public boolean edit(int id, CustomerUseService customerUseService) {
        return false;
    }

    public boolean delete(int id) {
        return false;
    }
}
