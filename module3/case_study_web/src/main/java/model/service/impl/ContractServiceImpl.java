package model.service.impl;

import model.bean.AttachService;
import model.bean.Contract;
import model.bean.ContractDetail;
import model.repository.ContractRepository;
import model.service.IContractService;

import java.sql.SQLException;
import java.util.List;

public class ContractServiceImpl implements IContractService {
    ContractRepository contractRepository=new ContractRepository();
    @Override
    public boolean createContract(Contract contract) throws SQLException {
        return contractRepository.createContract(contract);
    }

    @Override
    public boolean createContractDetail(ContractDetail contractDetail) throws SQLException {
        return contractRepository.createContractDetail(contractDetail);
    }

    @Override
    public List<Contract> findByAllContract() {
        return contractRepository.findByAllContract();
    }

    @Override
    public List<AttachService> findByAllAttachService() {
        return contractRepository.findByAllAttachService();
    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public ContractDetail findByIdContractDT(int id) {
        return contractRepository.findByIdContractDT(id);
    }

    @Override
    public boolean edit(int idContract, Contract contract) {
        return contractRepository.edit(idContract,contract);
    }
}
