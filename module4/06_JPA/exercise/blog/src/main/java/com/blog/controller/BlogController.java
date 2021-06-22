package com.blog.controller;

import com.blog.model.entity.Blog;
import com.blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"","/blog"})
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping({"/"})
    public ModelAndView showListBlog(@RequestParam("nameS") Optional<String> nameS,@PageableDefault(value = 5) Pageable pageable){
        Page<Blog> blogList;
        ModelAndView modelAndView=new ModelAndView("list");
        if(nameS.isPresent()){
            blogList=blogService.searchByName(nameS.get(),pageable);
            modelAndView.addObject("nameS",nameS.get());
        }else {
            blogList=blogService.findAll(pageable);
        }
        modelAndView.addObject("blogList",blogList);
        return modelAndView;
         }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("/create","blog",new Blog());
    }
    @PostMapping("/create")
    public ModelAndView saveBlog(@ModelAttribute Blog blog){
        blogService.save(blog);
        return new ModelAndView("/create","blog",blog).addObject("message","Create is success");
    }
    @GetMapping("/edit")
    public ModelAndView showEditForm(@RequestParam Long id){
        Blog blog=blogService.findById(id);
        if (blog!=null){
            return new ModelAndView("/edit","blog",blog);
        }else {
            return new ModelAndView("/error-404");
        }
    }
    @PostMapping("/edit")
    public ModelAndView editBlog(@ModelAttribute Blog blog){
        blogService.save(blog);
        return new ModelAndView("/edit","blog",blog).addObject("message","edit is success");
    }
    @GetMapping("/delete")
    public ModelAndView showDeleteForm(@RequestParam Long id){
        Blog blog=blogService.findById(id);
        if (blog!=null){
            return new ModelAndView("/delete","blog",blog);
        }else {
            return new ModelAndView("/error-404");
        }
    }
    @PostMapping("/delete")
    public String deleteBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("message","delete is success");
        return "redirect:/blog/";
    }

}
