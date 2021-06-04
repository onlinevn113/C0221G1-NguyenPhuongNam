package model.service.impl;

import model.bean.Service;
import model.repository.ServiceRepository;
import model.service.IServiceService;

import java.sql.SQLException;
import java.util.List;

public class ServiceServiceImpl implements IServiceService {
    ServiceRepository serviceRepository=new ServiceRepository();
    @Override
    public List<Service> findByAll() {
        return serviceRepository.findByAll();
    }

    @Override
    public List<Service> findByName(String name) {
        return serviceRepository.findByName(name);
    }

    @Override
    public Service findById(int id) {
        return serviceRepository.findById(id);
    }

    @Override
    public boolean create(Service service) throws SQLException {
        return serviceRepository.create(service);
    }

    @Override
    public boolean edit(int id, Service service) {
        return serviceRepository.edit(id,service);
    }

    @Override
    public boolean delete(int id) {
        return serviceRepository.delete(id);
    }
}
