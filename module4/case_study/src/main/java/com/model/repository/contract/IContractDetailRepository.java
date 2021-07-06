package com.model.repository.contract;

import com.model.entity.contract.ContractDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository extends PagingAndSortingRepository<ContractDetail,Long> {
}
