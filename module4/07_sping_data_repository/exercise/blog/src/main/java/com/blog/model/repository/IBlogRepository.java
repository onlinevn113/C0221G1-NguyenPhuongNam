package com.blog.model.repository;

import com.blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


@Transactional
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {

    @Query(value = "select * from blog where author like %?1%", nativeQuery = true)
    Page<Blog> searchByName(String nameS, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByAuthorContaining(String nameS, Pageable pageable);

//    @Query(value = "select * from blog b order by `date` desc ", nativeQuery = true)
    @Query(value = "select id, author, content, date_format(`date`, '%e-%m-%Y') as `date`, category_id " +
            "from blog " +
            "order by `date` desc, id desc", nativeQuery = true)
//    @Query(value = "select b.id,b.author,b.content,b.`date`,b.category_id from blog b order by b.`date` desc ,b.id desc", nativeQuery = true)
    Page<Blog> sortByDate(Pageable pageable);

    Page<Blog> findAllByOrderByDateDesc(Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO `blog` (`author`, `content`, `date`, `category_id`)" +
            "VALUES (:author, :content, curdate(),:category_id)", nativeQuery = true)
    void insertIntoBlog(@Param("author") String name,
                        @Param("content") String content,
                        @Param("category_id") Long categoryId);
}
