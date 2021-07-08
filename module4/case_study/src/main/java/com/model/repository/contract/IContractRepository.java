package com.model.repository.contract;

import com.model.entity.contract.Contract;
import com.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IContractRepository extends PagingAndSortingRepository<Contract,Long> {

    @Query(value = "select *" +
            " from contract  " +
            "join customer on contract.customer_id=customer.id " +
            "where customer.name  like :nameS and contract.flag=0 and (curdate() between start_date and end_date) order by contract.id desc",nativeQuery = true)
    Page<Contract> findAllContract(@Param("nameS") String name, Pageable pageable);
//    @Query(value = "select * from contract",nativeQuery = true)
//    Page<Contract> findAlLContract(String name ,Pageable pageable);
}
