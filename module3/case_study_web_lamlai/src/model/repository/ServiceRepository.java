package model.repository;

import model.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    BaseRepository baseRepository = new BaseRepository();


    public List<Service> findByName(String name1) {
        List<Service> services = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from service where service_name like ?");
            statement.setString(1, "%" + name1 + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                int serviceCost = resultSet.getInt("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                int poolArea = resultSet.getInt("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                services.add(new Service(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom,
                        descriptionOtherConvenience, poolArea, numberOfFloors));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }


    public Service findById(int id) {
        Connection connection = baseRepository.connectDataBase();
        Service service = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from service where service_id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                int serviceCost = resultSet.getInt("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                int poolArea = resultSet.getInt("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                service = new Service(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId,
                        standardRoom, descriptionOtherConvenience,
                        poolArea, numberOfFloors);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }


    public boolean create(Service service) throws SQLException {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into service(service_name, service_area, service_cost, " +
                    "service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors)" +
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


    public boolean edit(int id, Service service) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();

        try {
            PreparedStatement statement = connection.prepareStatement("update service\n" +
                    "set service_name=?,service_area=?,service_cost=?,service_max_people=?,rent_type_id=?,service_type_id=?,\n" +
                    "standard_room=?,description_other_convenience=?,pool_area=?,number_of_floors=?\n" +
                    "where service_id=?;");
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
            statement.setInt(11, id);
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
            PreparedStatement statement = connection.prepareStatement("delete from service where service_id=?");
            statement.setInt(1, id);
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public static void main(String[] args) {
        System.out.println(new ServiceRepository().findByAll().size());
    }
    public List<Service> findByAll() {
        Connection connection = baseRepository.connectDataBase();
        List<Service> services = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from service");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                int serviceCost = resultSet.getInt("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                int poolArea = resultSet.getInt("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                services.add(new Service(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId, standardRoom,
                        descriptionOtherConvenience, poolArea, numberOfFloors));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    public List<ServiceType> findByAllServiceType() {
        Connection connection = baseRepository.connectDataBase();
        List<ServiceType> serviceTypes = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from service_type");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int serviceTypeId=resultSet.getInt("service_type_id");
                String serviceTypeName=resultSet.getString("service_type_name");
                serviceTypes.add(new ServiceType(serviceTypeId,serviceTypeName));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypes;
    }

    public List<RentType> findByAllRentType() {
        Connection connection = baseRepository.connectDataBase();
        List<RentType> rentTypes = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from rent_type ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int rent_type_id=resultSet.getInt("rent_type_id");
                String rent_type_name=resultSet.getString("rent_type_name");
                int rent_type_cost=resultSet.getInt("rent_type_cost");
                rentTypes.add(new RentType(rent_type_id,rent_type_name,rent_type_cost));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypes;
    }
}
