package model.service;

import model.bean.AttachService;
import model.bean.Contract;
import model.bean.ContractDetail;
import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface IContractService {
    boolean createContract(Contract contract) throws SQLException;
    boolean createContractDetail(ContractDetail contractDetail) throws SQLException;
    List<Contract> findByAllContract() ;
    List<AttachService> findByAllAttachService() ;
    Contract findById(int id);
    ContractDetail findByIdContractDT(int id);
    boolean edit(int idContract,Contract contract);
}
