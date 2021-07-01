package com.blog.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String content;
    @Column(columnDefinition = "DATE")
    private String date;
    @JsonManagedReference
    @ManyToOne
    private Category category;

}
