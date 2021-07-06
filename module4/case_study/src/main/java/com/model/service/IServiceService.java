package com.model.service;

import com.model.entity.service.RentType;
import com.model.entity.service.Service;
import com.model.entity.service.ServiceType;

import java.util.List;

public interface IServiceService extends IGeneralService<Service>{
    List<RentType> findAllRentType();
    List<ServiceType> findAllServiceType();
    List<Service> findAll();
}
