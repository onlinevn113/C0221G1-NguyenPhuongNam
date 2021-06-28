package com.example.model.service.impl;

import com.example.model.entity.Book;
import com.example.model.repository.BookRepository;
import com.example.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private   BookRepository bookRepository;
    @Override
    public Iterable<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }
}
