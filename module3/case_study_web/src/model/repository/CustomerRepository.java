package model.repository;

import model.bean.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    public static void main(String[] args) {


    }
    BaseRepository baseRopository = new BaseRepository();
    final String SELECT_ALL_CUSTOMER = "select * from khach_hang;";

    final String SELECT_CUCTOMER_BY_ID = "select * from khach_hang where id_khach_hang=?;";

    final String UPDATE_CUSTOMER_BY_ID = "update khach_hang \n" +
            "set id_loai_khach=?, ho_ten='?', ngay_sinh='?', so_cmnd=?, \n" +
            "so_dien_thoai=?,email='?',dia_chi='?'\n" +
            "where id_khach_hang=?;";

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
                String sex=resultSet.getNString("gioi_tinh");
                String idCard = resultSet.getString("so_cmnd");
                String phoneNumber = resultSet.getNString("so_dien_thoai");
                String email = resultSet.getNString("email");
                String address = resultSet.getNString("dia_chi");
                customers.add(new Customer(idCustomer, idTypeCustomer, name, dateOfBirth,sex, idCard, phoneNumber, email, address));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    public Customer findById(int id) {
        Connection connection=baseRopository.connectDataBase();
        Customer customer=null;
        try {
            PreparedStatement statement=connection.prepareStatement(SELECT_CUCTOMER_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("id_khach_hang");
                int idTypeCustomer = resultSet.getInt("id_loai_khach");
                String name = resultSet.getString("ho_ten");
                String dateOfBirth = resultSet.getString("ngay_sinh");
                String idCard = resultSet.getString("so_cmnd");
                String phoneNumber = resultSet.getNString("so_dien_thoai");
                String email = resultSet.getNString("email");
                String address = resultSet.getNString("dia_chi");
                customer=new Customer(idCustomer, idTypeCustomer, name, dateOfBirth, idCard, phoneNumber, email, address);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return customer;
    }




    public boolean create(Customer customer) throws SQLException {
        Connection connection=baseRopository.connectDataBase();
        CallableStatement callableStatement;
        try{
            callableStatement=connection.prepareCall("{call create_customer(?,?,?,?,?,?,?,?)}");
            callableStatement.setInt(1,customer.getIdTypeCustomer());
            callableStatement.setString(2,customer.getName());
            callableStatement.setString(3,customer.getName());
            callableStatement.setString(4,customer.getName());
            callableStatement.setString(5,customer.getName());
            callableStatement.setString(6,customer.getName());
            callableStatement.setString(7,customer.getName());
            callableStatement.close();
            connection.close();
            return callableStatement.executeUpdate()>0;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean update(int id, Customer customer) {
//        Connection connection=baseRopository.connectDataBase();
//        try{
//            PreparedStatement
//        }
//

        return false;
    }


    public boolean delete(int id) {
        return false;
    }


}
