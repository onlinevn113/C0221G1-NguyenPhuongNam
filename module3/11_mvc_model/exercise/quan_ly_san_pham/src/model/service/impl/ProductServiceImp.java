package model.service.impl;
import model.bean.Product;
import model.repository.ProductRepository;
import model.service.IProductService;

import java.util.List;

public class ProductServiceImp implements IProductService {
    ProductRepository productRepository = new ProductRepository();


    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void update(String id, Product product) {
        productRepository.update(id,product);
    }

    @Override
    public void delete(String id) {
        productRepository.delete(id);
    }
}
