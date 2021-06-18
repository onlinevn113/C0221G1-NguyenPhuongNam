package com.model.service.impl;

import com.model.bean.Product;
import com.model.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductServiceImpl implements IProductService {
    private static final Map<Integer,Product> product =new HashMap<>() ;
    static {
        product.put(1,new Product(1,"dien thoai",500,"tot"));
        product.put(2,new Product(2,"may tinh",5000,"xau"));
        product.put(3,new Product(3,"tivi",5000,"xau"));
        product.put(4,new Product(4,"tu lanh",7000,"tot"));
    }

    @Override
    public List<Product> findAll() {

        return new ArrayList<>(product.values());
    }

    @Override
    public void save(Product product) {
        this.product.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return product.get(id);
    }

    @Override
    public void update(int id, Product product) {
        this.product.put(id,product);
    }

    @Override
    public void remove(int id) {
        product.remove(id);
    }


    @Override
    public List<Product> findByName(String name) {
        List<Product> productList=new ArrayList<>(product.values());
        List<Product> productSearch = new ArrayList<>();
        for (Product p:productList){
            if (p.getName().toLowerCase().contains(name.toLowerCase())){
                productSearch.add(p);
            }
        }
        return productSearch;
    }
}
