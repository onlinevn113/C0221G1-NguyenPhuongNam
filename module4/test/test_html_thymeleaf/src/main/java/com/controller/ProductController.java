package com.controller;


import com.model.bean.Product;
import com.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequestMapping(value = {"", "/product"})
@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("/index", "products", productService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("/create", "product", new Product());
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id) {
        return new ModelAndView("/edit", "product", productService.findById(id));
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id) {
        return new ModelAndView("/delete", "product", productService.findById(id));
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("/views", "product", productService.findById(id));
    }

//    @PostMapping("/search")
//    public String search(@RequestParam String nameSearch, RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("products", productService.findByName(nameSearch));
//        return "redirect:/product";
//    }
    @PostMapping("/search")
    public ModelAndView search(@RequestParam String nameSearch){
        return new ModelAndView("/index","products",productService.findByName(nameSearch));
    }

}
