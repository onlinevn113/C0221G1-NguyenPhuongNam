package com.blog.model.service.repository;

import com.blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    @Query(value = "select * from blog where author like %?1%", nativeQuery = true)
    Page<Blog> searchByName(String nameS, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByAuthorContaining(String nameS, Pageable pageable);


//    @Query(value = "select * from blog order by date(`date`) desc,second(`date`) desc;", nativeQuery = true)
//    Page<Blog> sortByDate(Pageable pageable);


    Page<Blog> findAllByOrderByDateDesc(Pageable pageable);
}
