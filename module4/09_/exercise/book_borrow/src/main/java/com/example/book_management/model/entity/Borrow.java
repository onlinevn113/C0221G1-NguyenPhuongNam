package com.example.book_management.model.entity;

import javax.persistence.*;

@Entity
public class Borrow {
    @Id
    private Long code;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Borrow() {
    }

    public Borrow(Long code, Book book) {
        this.code = code;
        this.book = book;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
