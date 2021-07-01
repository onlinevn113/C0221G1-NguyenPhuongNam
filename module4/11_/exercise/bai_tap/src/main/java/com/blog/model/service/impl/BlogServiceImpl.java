package com.blog.model.service.impl;

import com.blog.model.entity.Blog;
import com.blog.model.repository.IBlogRepository;
import com.blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return (List) blogRepository.findAll();
    }
    @Override
    public List<Blog> finBlogInCategory(Long id) {
        return (List) blogRepository.findBlogInCategory(id);
    }
    @Override
    public Blog findById(Long id)   {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blog.setDate(LocalDate.now().toString());
        blogRepository.save(blog);
//        blogRepository.insertIntoBlog(blog.getAuthor(),blog.getContent(),blog.getCategory().getId());
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> searchByName(String nameS, Pageable pageable) {
        Page<Blog> blogPage=blogRepository.findAllByAuthorContaining(nameS,pageable);
//        for (Blog b: blogPage){
//            b.setDate(new SimpleDateFormat("yyyy-MM-dd").format(b.getDate()) );
//        }
        return blogPage;
    }


    @Override
    public Page<Blog> sortByDate(Pageable pageable) {
        Page<Blog> blogPage=blogRepository.sortByDate(pageable);
//        for (Blog b: blogPage){
//            b.setDate(new SimpleDateFormat("yyyy-MM-dd").format(b.getDate()) );
//        }
        return blogPage;
    }



}
