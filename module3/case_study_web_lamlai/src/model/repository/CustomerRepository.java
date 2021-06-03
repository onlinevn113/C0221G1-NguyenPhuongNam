package model.repository;

import model.bean.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String SELECT_ALL_CUSTOMER = "select * from customer;";

    final String SELECT_CUCTOMER_BY_ID = "select * from customer where customer_id=?";


    public List<Customer> findByAll() {
        Connection connection = baseRepository.connectDataBase();
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("customer_id");
                int idTypeCustomer = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_name");
                String dateOfBirth = resultSet.getString("customer_birthday");
                int sex = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phoneNumber = resultSet.getNString("customer_phone");
                String email = resultSet.getNString("customer_email");
                String address = resultSet.getNString("customer_address");
                customers.add(new Customer(idCustomer,
                        idTypeCustomer, name, dateOfBirth, sex, idCard, phoneNumber, email, address)
                );
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Customer findById(int id) {
        Connection connection = baseRepository.connectDataBase();
        Customer customer = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CUCTOMER_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                customer = new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public List<Customer> findByName(String name1) {
        List<Customer> customers = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from customer where customer_name like ?");
            statement.setString(1, "%" + name1 + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customer_id = resultSet.getInt("customer_id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_name = resultSet.getString("customer_name");
                String customer_birthday = resultSet.getString("customer_birthday");
                int customer_gender = resultSet.getInt("customer_gender");
                String customer_id_card = resultSet.getString("customer_id_card");
                String customer_phone = resultSet.getString("customer_phone");
                String customer_email = resultSet.getString("customer_email");
                String customer_address = resultSet.getString("customer_address");
                customers.add(new Customer(customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }


    public boolean createCustomer(Customer customer) throws SQLException {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into customer(customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email, customer_address) " +
                    "values(?,?,?,?,?,?,?,?)");
            statement.setInt(1, customer.getIdTypeCustomer());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getDateOfBirth());
            statement.setInt(4, customer.getSex());
            statement.setString(5, customer.getIdCard());
            statement.setString(6, customer.getPhoneNumber());
            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getAddress());
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean delete(int id) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement( "delete from customer where customer_id=?");
            statement.setInt(1, id);
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean edit(int id, Customer customer) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();

        try {
            PreparedStatement statement = connection.prepareStatement("update customer " +
                    "set customer_type_id=?,customer_name=?,customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=?" +
                    "where customer_id=?");
            statement.setInt(1, customer.getIdTypeCustomer());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getDateOfBirth());
            statement.setInt(4, customer.getSex());
            statement.setString(5, customer.getIdCard());
            statement.setString(6, customer.getPhoneNumber());
            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getAddress());
            statement.setInt(9, id);
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
