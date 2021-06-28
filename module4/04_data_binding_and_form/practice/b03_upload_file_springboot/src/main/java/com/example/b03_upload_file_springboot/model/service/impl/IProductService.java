package com.example.b03_upload_file_springboot.model.service.impl;

import com.example.b03_upload_file_springboot.model.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void remove(Integer id);
}
