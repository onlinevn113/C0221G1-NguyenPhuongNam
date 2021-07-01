package com.blog.model.service;

import com.blog.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll(Pageable pageable);
    void save(Category category);
    List<Category> findAllList();
}
