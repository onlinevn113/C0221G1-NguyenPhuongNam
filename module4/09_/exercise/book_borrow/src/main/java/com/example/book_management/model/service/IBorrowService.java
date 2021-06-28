package com.example.book_management.model.service;

import com.example.book_management.model.entity.Borrow;

import java.util.Optional;

public interface IBorrowService {
    Iterable<Borrow> findAll();

    Optional<Borrow> findById(Long id);

    void save(Borrow borrow);

    void remove(Long id);
}
