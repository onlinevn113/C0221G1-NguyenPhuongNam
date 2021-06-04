package model.repository;

import model.bean.Employee;
import model.bean.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    BaseRepository baseRepository = new BaseRepository();


    public List<Service> findByName(String name) {
        return null;
    }


    public Service findById(int id) {
        return null;
    }

    ;

    public static void main(String[] args) {
        ServiceRepository serviceRepository = new ServiceRepository();
        try {
            System.out.println(serviceRepository.create(new Service("nam", 1, 1, 1, 1, 1, "a", "2", 1, 1))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean create(Service service) throws SQLException {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into service(service_name, service_area, service_cost, " +
                    "service_max_people, rent_type_id, service_type_id, standrad_room, description_other_convenience, pool_area, number_of_floors)" +
                    "values (?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, service.getServiceName());
            statement.setInt(2, service.getServiceArea());
            statement.setInt(3, service.getServiceCost());
            statement.setInt(4, service.getServiceMaxPeople());
            statement.setInt(5, service.getRentTypeId());
            statement.setInt(6, service.getServiceTypeId());
            statement.setString(7, service.getStandardRoom());
            statement.setString(8, service.getDescriptionOtherConvenience());
            statement.setInt(9, service.getPoolArea());
            statement.setInt(10, service.getNumberOfFloors());
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<Service> findByAll() {
        return null;
    }

    public boolean edit(int id, Service service) {
        return false;
    }


    public boolean delete(int id) {
        return false;
    }
}
