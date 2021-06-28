package com.example.b03_upload_file_springboot.model.service.impl;

import com.example.b03_upload_file_springboot.model.bean.Product;
import com.example.b03_upload_file_springboot.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        productRepository.deleteById(id);
    }
}
