package model.service;

import model.bean.Customer;
import model.bean.RentType;
import model.bean.Service;
import model.bean.ServiceType;

import java.sql.SQLException;
import java.util.List;

public interface IServiceService {
    List<Service> findByAll() ;
    List<Service> findByName(String name) ;
    Service findById(int id);
    boolean create(Service service) throws SQLException;
    boolean edit(int id,Service service);
    boolean delete(int id);

    List<ServiceType> findByAllServiceType() ;
    List<RentType> findByAllRentType() ;
}
