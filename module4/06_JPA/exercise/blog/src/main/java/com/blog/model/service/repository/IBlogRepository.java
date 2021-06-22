package com.blog.model.service.repository;

import com.blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IBlogRepository extends JpaRepository<Blog,Long> {
    @Query(value = "select * from blog where author like %?1%",nativeQuery = true)
    Page<Blog> searchByName(String nameS, Pageable pageable);
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByAuthorContaining(String nameS,Pageable pageable);
}
