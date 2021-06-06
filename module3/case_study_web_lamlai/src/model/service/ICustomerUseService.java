package model.service;

import model.bean.AttachService;
import model.bean.Customer;
import model.bean.Service;

import java.util.List;

public interface ICustomerUseService {
    List<Customer> findByAllUseService();
    List<Service> findByAllService(int idCustomer);
    List<AttachService> findByAllAttachService(int idContract);
}
