package com.model.service.impl;

import com.model.entity.contract.AttachService;
import com.model.entity.contract.Contract;
import com.model.entity.contract.ContractDetail;
import com.model.repository.contract.IAttachServiceRepository;
import com.model.repository.contract.IContractDetailRepository;
import com.model.repository.contract.IContractRepository;
import com.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;
    @Autowired
    IAttachServiceRepository attachServiceRepository;
    @Autowired
    IContractDetailRepository contractDetailRepository;



    @Override
    public List<AttachService> attachServices() {
        return (List<AttachService>) attachServiceRepository.findAll();
    }

    @Override
    public List<ContractDetail> contractDetails() {
        return (List<ContractDetail>) contractDetailRepository.findAll();
    }

    @Override
    public List<Contract> findAll() {
        return (List<Contract>) contractRepository.findAll();
    }

    @Override
    public void save(ContractDetail o) {
        contractDetailRepository.save(o);
    }

    @Override
    public Page<Contract> findAll(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Contract findById(Long id) {
        return null;
    }

    @Override
    public void save(Contract o) {
        contractRepository.save(o);
    }

    @Override
    public void remove(Long id) {

    }
}
