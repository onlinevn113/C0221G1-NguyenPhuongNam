package com.example.book_management.model.repository;

import com.example.book_management.model.entity.Borrow;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowRepository extends PagingAndSortingRepository<Borrow,Long> {
}
