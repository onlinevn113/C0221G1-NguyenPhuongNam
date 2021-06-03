package model.repository;

import model.bean.CustomerType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeCustomerRepository {
    BaseRepository baseRepository = new BaseRepository();

    public List<CustomerType> findAllCustomerType(){
        List<CustomerType> customerTypes = new ArrayList<>();
        try {
            Connection connection = baseRepository.connectDataBase();
            PreparedStatement statement = connection.prepareStatement("select * from customer_type");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int customer_type_id = resultSet.getInt("customer_type_id");
                String customer_type_name = resultSet.getString("customer_type_name");
                customerTypes.add(new CustomerType(customer_type_id, customer_type_name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypes;
    }

}
