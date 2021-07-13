package com.model.repository.customer;

import com.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    @Query(value = "select * from customer where name like %?1% && flag = 0 && birthday like %?2% && id_card like %?3% order by id desc ",nativeQuery = true)
    Page<Customer> findAllCustomer(String name,String birthday,String idCard, Pageable pageable);

}
