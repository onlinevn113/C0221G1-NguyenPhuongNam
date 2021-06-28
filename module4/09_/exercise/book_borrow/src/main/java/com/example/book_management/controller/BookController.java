package com.example.book_management.controller;

import com.example.book_management.exception.BookException;
import com.example.book_management.exception.NotFoundException;
import com.example.book_management.model.entity.Book;
import com.example.book_management.model.entity.Borrow;
import com.example.book_management.model.service.IBookService;
import com.example.book_management.model.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value = {"","/books"})
public class BookController {

    @Autowired
    IBookService bookService;
    @Autowired
    IBorrowService borrowService;

    @GetMapping("")
    public String goHome(Model model){
        model.addAttribute("books",this.bookService.findAll());
        return "home";
    }

    @GetMapping("/show")
    public String showInfo(@RequestParam Long id,Model model){
        model.addAttribute("book",this.bookService.findById(id).get());
        return "show";
    }

    @GetMapping("/borrow")
    public String borrowBook(@RequestParam Long id, Model model) throws BookException {
        Optional<Book> book = this.bookService.findById(id);
        int quantity = book.get().getQuantity();
        if (quantity>=1){
            quantity--;
            book.get().setQuantity(quantity);
        }else {
            throw new BookException();
        }
        this.bookService.save(book.get());
        Long code = Math.round(Math.random()*89999 + 10000);
        Borrow borrow = new Borrow(code,book.get());
        this.borrowService.save(borrow);
        model.addAttribute("book",book.get());
        model.addAttribute("msg","Your code borrow is :"+code);
        return "show";
    }

    @GetMapping("/pay")
    public String payBook(@RequestParam Long code, RedirectAttributes redirectAttributes) throws NotFoundException {
        Borrow borrow = this.borrowService.findById(code).orElse(null);
        if (borrow ==  null){
            throw new NotFoundException();
        }
        Long id = borrow.getBook().getId();
        Book book = this.bookService.findById(id).get();
        book.setQuantity(book.getQuantity()+1);
        this.bookService.save(book);
        this.borrowService.remove(code);
        redirectAttributes.addFlashAttribute("msg","Pay successfully");
        return "redirect:/books";
    }

    @ExceptionHandler(BookException.class)
    public String bookException(){
        return "book_exception";
    }

    @ExceptionHandler(NotFoundException.class)
    public String notFoundException(){
        return "error_not_found";
    }



}
