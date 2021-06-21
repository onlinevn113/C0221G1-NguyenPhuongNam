package com.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ImgOfDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rate;
    private String author;
    private String feedBack;
    private Date time = new Date(System.currentTimeMillis());
    private int like;

    public ImgOfDay() {
    }

    public ImgOfDay(int rate, String author, String feedBack, Date time, int like) {
        this.rate = rate;
        this.author = author;
        this.feedBack = feedBack;
        this.time = time;
        this.like = like;
    }

    public ImgOfDay(int id, int rate, String author, String feedBack, Date time, int like) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.feedBack = feedBack;
        this.time = time;
        this.like = like;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
