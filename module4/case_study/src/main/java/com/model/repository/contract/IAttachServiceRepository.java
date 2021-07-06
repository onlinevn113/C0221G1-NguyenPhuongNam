package com.model.repository.contract;

import com.model.entity.contract.AttachService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachServiceRepository extends PagingAndSortingRepository<AttachService,Long> {
}
