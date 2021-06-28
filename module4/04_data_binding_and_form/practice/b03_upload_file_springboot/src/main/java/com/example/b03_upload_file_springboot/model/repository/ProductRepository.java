package com.example.b03_upload_file_springboot.model.repository;

import com.example.b03_upload_file_springboot.model.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
}
