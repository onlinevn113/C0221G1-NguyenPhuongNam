package model.repository;

import model.bean.AttachService;
import model.bean.Contract;
import model.bean.Customer;
import model.bean.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUseServiceRepository {
    BaseRepository baseRepository = new BaseRepository();


    public List<Customer> findByAllUseService() {
        Connection connection = baseRepository.connectDataBase();
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select c.customer_id,customer_name,customer_birthday,contract_id\n" +
                    "from customer c\n" +
                    "join contract ct on ct.customer_id=c.customer_id\n" +
                    "where date(now()) between contract_start_date and contract_end_date\n" +
                    "group by c.customer_id\n" +
                    ";");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                String dateOfBirth = resultSet.getString("customer_birthday");
                int contractId=resultSet.getInt("contract_id");
                customers.add(new Customer(idCustomer,name, dateOfBirth,contractId)
                );
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public List<Service> findByAllService(int idCustomer) {
        Connection connection = baseRepository.connectDataBase();
        List<Service> services = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select sv.service_id,service_name,contract_start_date,contract_end_date,contract_id\n" +
                    "from service sv\n" +
                    "join contract ct on sv.service_id=ct.service_id\n" +
                    "where date(now()) between ct.contract_start_date and ct.contract_end_date and customer_id=? ;");
            statement.setInt(1,idCustomer);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int serviceId=resultSet.getInt("service_id");
                String serviceName=resultSet.getString("service_name");
                String startDate=resultSet.getString("contract_start_date");
                String endDate=resultSet.getString("contract_end_date");
                int contractId=resultSet.getInt("contract_id");
                services.add(new Service(serviceId,serviceName,startDate,endDate,contractId));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    public List<AttachService> findByAllAttachService(int idContract) {
        Connection connection = baseRepository.connectDataBase();
        List<AttachService> attachServices = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select ats.attach_service_id,attach_service_name,attach_service_cost,attach_service_unit,attach_service_status\n" +
                    "from attach_service ats\n" +
                    "join contract_detail cd on ats.attach_service_id=cd.attach_service_id\n" +
                    "join contract ct on ct.contract_id=cd.contract_id\n" +
                    "where date(now()) between contract_start_date and contract_end_date and cd.contract_id=?;");
            statement.setInt(1,idContract);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int attachId=resultSet.getInt("ats.attach_service_id");
                String attachName=resultSet.getString("attach_service_name");
                double attachCost=resultSet.getDouble("attach_service_cost");
                int attachUnit=resultSet.getInt("attach_service_unit");
                String attachStatus=resultSet.getString("attach_service_unit");
                attachServices.add(new AttachService(attachId,attachName,attachCost,attachUnit,attachStatus));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attachServices;
    }

    public boolean deleteServiceInContract(int id) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from contract\n" +
                    "where contract_id=?;");
            statement.setInt(1, id);
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }



}
