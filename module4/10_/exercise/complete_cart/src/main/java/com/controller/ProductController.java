package com.controller;


import com.model.Cart;
import com.model.entity.Product;
import com.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping({"/shop", ""})
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping({""})
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id, @ModelAttribute Cart cart, @RequestParam("action") String action, RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "error-404";
        }
        if (action.equals("+")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("-")) {
            cart.minusProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
//        if (action.equals("delete")) {
//            cart.(productOptional.get());
//            return "redirect:/shopping-cart";
//        }
        redirectAttributes.addFlashAttribute("msg", "Add " + productOptional.get().getName() + " Successfully");
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
}
