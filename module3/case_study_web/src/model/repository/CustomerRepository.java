package model.repository;

import model.bean.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = new Customer(1, "f", "2000-02-02", "a", "a", "a", "a", "a");
        try {
            System.out.println(customerRepository.createCustomer(customer));
            System.out.println(customerRepository.createCustomer(customer));
            System.out.println(customerRepository.createCustomer(customer));
            System.out.println(customerRepository.createCustomer(customer));
            System.out.println(customerRepository.createCustomer(customer));
            System.out.println(customerRepository.createCustomer(customer));
            System.out.println(customerRepository.createCustomer(customer));
            System.out.println(customerRepository.createCustomer(customer));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    BaseRepository baseRopository = new BaseRepository();
    final String SELECT_ALL_CUSTOMER = "select * from khach_hang;";

    final String SELECT_CUCTOMER_BY_ID = "select * from khach_hang where id_khach_hang=?;";


    public List<Customer> findByAll() {
        Connection connection = baseRopository.connectDataBase();
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("id_khach_hang");
                int idTypeCustomer = resultSet.getInt("id_loai_khach");
                String name = resultSet.getString("ho_ten");
                String dateOfBirth = resultSet.getString("ngay_sinh");
                String sex = resultSet.getNString("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phoneNumber = resultSet.getNString("so_dien_thoai");
                String email = resultSet.getNString("email");
                String address = resultSet.getNString("dia_chi");
                customers.add(new Customer(idCustomer, idTypeCustomer, name, dateOfBirth, sex, idCard, phoneNumber, email, address));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Customer findById(int id) {
        Connection connection = baseRopository.connectDataBase();
        Customer customer = null;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CUCTOMER_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("id_khach_hang");
                int idTypeCustomer = resultSet.getInt("id_loai_khach");
                String name = resultSet.getString("ho_ten");
                String dateOfBirth = resultSet.getString("ngay_sinh");
                String sex = resultSet.getNString("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phoneNumber = resultSet.getNString("so_dien_thoai");
                String email = resultSet.getNString("email");
                String address = resultSet.getNString("dia_chi");
                customer = new Customer(idCustomer, idTypeCustomer, name, dateOfBirth, sex, idCard, phoneNumber, email, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public List<Customer> findByName(String name1){
        Connection connection = baseRopository.connectDataBase();
        List<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from khach_hang where ho_ten like ?");
            statement.setString(1,"%"+name1+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("id_khach_hang");
                int idTypeCustomer = resultSet.getInt("id_loai_khach");
                String name = resultSet.getString("ho_ten");
                String dateOfBirth = resultSet.getString("ngay_sinh");
                String sex = resultSet.getNString("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phoneNumber = resultSet.getNString("so_dien_thoai");
                String email = resultSet.getNString("email");
                String address = resultSet.getNString("dia_chi");
                customers.add(new Customer(idCustomer, idTypeCustomer, name, dateOfBirth, sex, idCard, phoneNumber, email, address));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }




    public boolean createCustomer(Customer customer) throws SQLException {
        Connection connection = baseRopository.connectDataBase();
        CallableStatement callableStatement;
        boolean check = false;
        try {
            callableStatement = connection.prepareCall("{call create_customer(?,?,?,?,?,?,?,?)}");
            callableStatement.setInt(1, customer.getIdTypeCustomer());
            callableStatement.setString(2, customer.getName());
            callableStatement.setString(3, customer.getDateOfBirth());
            callableStatement.setString(4, customer.getSex());
            callableStatement.setString(5, customer.getIdCard());
            callableStatement.setString(6, customer.getPhoneNumber());
            callableStatement.setString(7, customer.getEmail());
            callableStatement.setString(8, customer.getAddress());
            check = callableStatement.executeUpdate() > 0;
            callableStatement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
    public boolean delete(int id) {
        boolean check = false;
        Connection connection = baseRopository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from khach_hang where id_khach_hang=?");
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean edit(int id, Customer customer) {
        boolean check = false;
        Connection connection = baseRopository.connectDataBase();
        try {
            CallableStatement callableStatement = connection.prepareCall("{call edit_customer(?,?,?,?,?,?,?,?,?)}");
            callableStatement.setInt(1, customer.getIdTypeCustomer());
            callableStatement.setString(2, customer.getName());
            callableStatement.setString(3, customer.getDateOfBirth());
            callableStatement.setString(4, customer.getSex());
            callableStatement.setString(5, customer.getIdCard());
            callableStatement.setString(6, customer.getPhoneNumber());
            callableStatement.setString(7, customer.getEmail());
            callableStatement.setString(8, customer.getAddress());
            callableStatement.setInt(9, id);
            check = callableStatement.executeUpdate() > 0;

            callableStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
