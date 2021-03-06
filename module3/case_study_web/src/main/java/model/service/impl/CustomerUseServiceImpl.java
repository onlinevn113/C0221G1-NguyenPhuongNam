package model.service.impl;

import model.bean.AttachService;
import model.bean.Customer;
import model.bean.Service;
import model.repository.CustomerUseServiceRepository;
import model.service.ICustomerUseService;

import java.util.List;

public class CustomerUseServiceImpl implements ICustomerUseService {
    CustomerUseServiceRepository customerUseServiceRepository=new CustomerUseServiceRepository();


    @Override
    public List<Customer> findByAllUseService() {
        return customerUseServiceRepository.findByAllUseService();
    }

    @Override
    public List<Service> findByAllService(int idCustomer) {
        return customerUseServiceRepository.findByAllService(idCustomer);
    }

    @Override
    public List<AttachService> findByAllAttachService(int idContract) {
        return customerUseServiceRepository.findByAllAttachService(idContract);
    }

    @Override
    public boolean deleteServiceInContract(int id) {
        return customerUseServiceRepository.deleteServiceInContract(id);
    }

    @Override
    public boolean deleteAttachService(int id) {
        return customerUseServiceRepository.deleteAttachService(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerUseServiceRepository.findByName(name);
    }


}
