package com.example.book_management.model.service;

import com.example.book_management.model.entity.Book;

import java.util.Optional;

public interface IBookService {
    Iterable<Book> findAll();

    Optional<Book> findById(Long id);

    void save(Book book);

    void remove(Long id);
}
