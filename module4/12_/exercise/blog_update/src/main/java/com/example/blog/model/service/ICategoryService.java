package com.example.blog.model.service;

import com.example.blog.model.entity.Blog;
import com.example.blog.model.entity.Category;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();

    Optional<Category> findById(Long id);

    void save(Category category);

    void remove(Long id);


}
