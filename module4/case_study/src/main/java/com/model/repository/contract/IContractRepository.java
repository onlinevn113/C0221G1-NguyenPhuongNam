package com.model.repository.contract;

import com.model.entity.contract.Contract;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends PagingAndSortingRepository<Contract,Long> {
}
