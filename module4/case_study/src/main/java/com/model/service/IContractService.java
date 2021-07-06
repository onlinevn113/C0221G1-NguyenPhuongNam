package com.model.service;

import com.model.entity.contract.AttachService;
import com.model.entity.contract.Contract;
import com.model.entity.contract.ContractDetail;

import java.util.List;

public interface IContractService extends IGeneralService<Contract> {
    List<AttachService> attachServices();
    List<ContractDetail> contractDetails();
    List<Contract> findAll();
    void save(ContractDetail o);
}
