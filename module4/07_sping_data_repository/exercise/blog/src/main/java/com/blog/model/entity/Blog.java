package com.blog.model.entity;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.*;


@Getter
@Setter
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String content;
    @Column(columnDefinition = "DATE")
    private String date;
    @ManyToOne
    @JoinColumn( referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(Long id, String author, String content, String date, Category category) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.date = date;
        this.category = category;
    }
}
