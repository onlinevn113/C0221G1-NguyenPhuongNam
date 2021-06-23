package com.blog.model.entity;


import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String content;
    private Date date=new Date(System.currentTimeMillis());
    @ManyToOne
    @JoinColumn( referencedColumnName = "id")
    private Category category;

    public Blog(Long id, String author, String content, Date date, Category category) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.date = date;
        this.category = category;
    }

    public Blog(Long id, String author, String content, Date date) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.date = date;
    }

    public Blog() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog(Long id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
