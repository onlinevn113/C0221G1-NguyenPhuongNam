package model.service;

import model.bean.Product;

import java.util.List;

public interface IProductService {

    List<Product> findByName(String name);
    Product findById(String id);

    void create(Product product);

    List<Product> findAll();

    void update(String id,Product product);

    void delete(String id);

}
