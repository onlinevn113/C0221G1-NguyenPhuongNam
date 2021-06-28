package com.example.controller;

import com.example.excrption.BookException;
import com.example.model.entity.Book;
import com.example.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping(value = {"/","/books"})
    public ModelAndView showListBook(){
        Iterable<Book> books= this.bookService.findAll();
        ModelAndView modelAndView= new ModelAndView("book/list");
        modelAndView.addObject("books",books);
        return  modelAndView;
    }

    @GetMapping("/books/{id}")
    public ModelAndView viewBook(@PathVariable ("id") Long id) {
        Book book = bookService.findById(id);
        if (book == null) {
            return new ModelAndView("error");
        }
        ModelAndView modelAndView = new ModelAndView("book/view");
        modelAndView.addObject("book", book);
        return modelAndView;
    }
    @GetMapping("/books/borrow/{id}")
    public ModelAndView borrowBook(@PathVariable Long id) {
        Book book = bookService.findById(id);
        if (book == null) {
            return new ModelAndView("error");
        }
        book.setQuantity(book.getQuantity() -1);
        if (book.getQuantity() < 0) {
            return new ModelAndView("error");
        }
        bookService.save(book);
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/books/get/{id}")
    public ModelAndView getBook(@PathVariable Long id) {
        Book book = bookService.findById(id);
        if (book == null) {
            return new ModelAndView("error");
        }
        book.setQuantity(book.getQuantity() +1);
        bookService.save(book);
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @ExceptionHandler(BookException.class)
    public  String handleBookException(){
        return "error";
    }
}
