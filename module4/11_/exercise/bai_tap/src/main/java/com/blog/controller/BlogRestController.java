package com.blog.controller;

import com.blog.model.entity.Blog;
import com.blog.model.entity.Category;
import com.blog.model.service.IBlogService;
import com.blog.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogRestController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/category/list")
    public ResponseEntity<List<Category>> showCategoryList(){
        List<Category> categories= categoryService.findAllList();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/blog/list")
    public ResponseEntity<List<Blog>> showBlogList(){
        List<Blog> blogs= blogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping("/blog/blog-in-category/{id}")
    public ResponseEntity<List<Blog>> showBlogInCategory(@PathVariable Long id ){
        List<Blog> blogs=blogService.finBlogInCategory(id);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }


    @GetMapping("/blog/detail/{id}")
    public ResponseEntity<Blog> showBlogDetail(@PathVariable Long id){
        Blog blog=blogService.findById(id);
        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
