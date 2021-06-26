package com.example.b03_product_springboot.model.service;


import com.example.b03_product_springboot.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProductService  {
    Page<Product> searchNameAndDate(@Param("search") String search, Pageable pageable);

    Page<Product> findAllSortDate(Pageable pageable);
    Iterable<Product> findAll();

    Optional<Product> findById(Integer id);

    void save(Product product);

    void remove(Integer id);
}