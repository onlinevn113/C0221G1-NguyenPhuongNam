package com.example.b03_product_springboot.model.repository;

import com.example.b03_product_springboot.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface IProductRepository extends PagingAndSortingRepository<Product, Integer> {
//    @Query(value = "select id,date_format(`date`,'%e-%m-%Y') `date`,`description`,manufacturer,`name`,price from product where concat(`name`, `date`) like :keySearch  order by `date` desc", nativeQuery = true)
    @Query(value = "select * from product where concat(`name`,' ',`date`) like :keySearch  order by `date` desc", nativeQuery = true)
    Page<Product> searchNameAndDate(@Param("keySearch") String keySearch, Pageable pageable);

    @Query(value = "select * from product order by `date` desc", nativeQuery = true)
    Page<Product> findAllSortDate(Pageable pageable);
}
