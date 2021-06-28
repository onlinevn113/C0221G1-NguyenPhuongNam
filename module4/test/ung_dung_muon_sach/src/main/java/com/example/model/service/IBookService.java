package com.example.model.service;

import com.example.model.entity.Book;
import org.springframework.stereotype.Service;

//@Service
public interface IBookService {
    Iterable<Book> findAll();

    Book findById(Long id);

    void save(Book book);

}
