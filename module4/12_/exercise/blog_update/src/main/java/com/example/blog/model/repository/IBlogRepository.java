package com.example.blog.model.repository;

import com.example.blog.model.entity.Blog;
import com.example.blog.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog , Integer> {
        Page<Blog> findAllByNameContaining(String name, Pageable pageable);
        Page<Blog> findAll(Pageable pageable);

        @Query(value = "select * from blog where category_id = ?1",nativeQuery = true)
        List<Blog> findAllBlogByCategory(Long category_id);

        @Query(value = "select  * from blog where name like %?1%",nativeQuery = true)
        List<Blog> findBlogByName(String name);
    
}
