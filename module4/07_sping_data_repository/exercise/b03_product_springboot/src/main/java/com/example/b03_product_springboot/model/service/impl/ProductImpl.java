package com.example.b03_product_springboot.model.service.impl;

import com.example.b03_product_springboot.model.entity.Product;
import com.example.b03_product_springboot.model.repository.IProductRepository;
import com.example.b03_product_springboot.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;
@Service
public class ProductImpl implements IProductService {
   @Autowired
    IProductRepository productRepository;
    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        product.setDate(LocalDate.now().toString());
        productRepository.save(product);
    }

    @Override
    public void remove(Integer id) {
        productRepository.deleteById(id);
    }
//
//    @Override
//    public Page<Product> searchNameAndDate(String search, Pageable pageable) {
//
//        return productRepository.searchNameAndDate('%'+search+'%', pageable);
//    }
    @Override
    public Page<Product> searchNameAndDate(String search, Pageable pageable) {
        Page<Product> pageable1=productRepository.searchNameAndDate('%'+search+'%', pageable);
        for(Product p:pageable1){
           String []a=p.getDate().split("-");
           String temp;
               temp=a[0];
               a[0]=a[2];
               a[2]=temp;
           p.setDate(a[0]+"-"+a[1]+"-"+a[2]);
        }
        return pageable1;
    }

    @Override
    public Page<Product> findAllSortDate(Pageable pageable) {
        Page<Product> pageable1=productRepository.findAllSortDate(pageable);
        for(Product p:pageable1){
            String []a=p.getDate().split("-");
            String temp;
            temp=a[0];
            a[0]=a[2];
            a[2]=temp;
            p.setDate(a[0]+"-"+a[1]+"-"+a[2]);
        }
        return pageable1;
    }
}
