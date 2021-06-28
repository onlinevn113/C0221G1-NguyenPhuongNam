package com.example.book_management.model.service.impl;

import com.example.book_management.model.entity.Borrow;
import com.example.book_management.model.repository.IBorrowRepository;
import com.example.book_management.model.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BorrowServiceImpl implements IBorrowService {
    @Autowired
    IBorrowRepository borrowRepository;
    @Override
    public Iterable<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public Optional<Borrow> findById(Long id) {
        return borrowRepository.findById(id);
    }

    @Override
    public void save(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    @Override
    public void remove(Long id) {
        borrowRepository.deleteById(id);
    }
}
