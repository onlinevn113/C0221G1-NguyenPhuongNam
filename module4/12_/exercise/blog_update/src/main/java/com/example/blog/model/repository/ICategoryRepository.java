package com.example.blog.model.repository;

import com.example.blog.model.entity.Blog;
import com.example.blog.model.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {
//    Iterable<Blog> findAllByCategory(Category category);
}
