package model.service;

import model.bean.*;

import java.util.List;

public interface ICustomerUseService {
    List<Customer> findByAllUseService();
    List<Service> findByAllService(int idCustomer);
    List<AttachService> findByAllAttachService(int idContract);
    boolean deleteServiceInContract(int id);
}
