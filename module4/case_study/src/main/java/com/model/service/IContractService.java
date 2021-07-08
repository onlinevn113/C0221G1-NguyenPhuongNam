package com.model.service;

import com.model.entity.contract.AttachService;
import com.model.entity.contract.Contract;
import com.model.entity.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService extends IGeneralService<Contract> {
    List<AttachService> attachServices();
    List<ContractDetail> contractDetails();
    List<Contract> findAll();
    Page<Contract> findAll(String search, Pageable pageable);
    void save(ContractDetail o);
}
