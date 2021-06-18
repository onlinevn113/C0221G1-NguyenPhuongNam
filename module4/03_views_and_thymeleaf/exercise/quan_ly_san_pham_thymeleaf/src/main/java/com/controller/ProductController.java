package com.controller;


import com.model.Product;
import com.service.IProductService;
import com.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequestMapping(value = {"", "/product"})
@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public ModelAndView index(){
        return new ModelAndView("/index","products",productService.findAll());
    }
    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/create","product",new Product());
    }
    @PostMapping("/save")
    public String save(Product product){
        product.setId((int)(Math.random()*10000));
        productService.save(product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("/edit","product",productService.findById(id));
    }
    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(),product);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        return new ModelAndView("/delete","product",productService.findById(id));
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes){
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success","Removed product successfully!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id){
        return new ModelAndView("/views","product",productService.findById(id));
    }

}
