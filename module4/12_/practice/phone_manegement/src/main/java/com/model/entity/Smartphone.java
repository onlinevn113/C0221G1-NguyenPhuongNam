package com.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String producer;
    private String model;
    private double price;
    @Override
    public String toString() {
        return producer+": "+model+" with price "+price;
    }
}
