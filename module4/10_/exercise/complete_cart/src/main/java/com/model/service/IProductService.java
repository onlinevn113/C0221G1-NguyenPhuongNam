package com.model.service;

import com.model.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Integer id);

    Product findById2(Integer id);
}
