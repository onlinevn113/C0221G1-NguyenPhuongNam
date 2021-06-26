package com.example.b03_product_springboot;

public class Main {
    public static void main(String[] args) {
        String a="^[\\p{L} .'-]+$";
        System.out.println("Nam1".matches(a));
    }
}
