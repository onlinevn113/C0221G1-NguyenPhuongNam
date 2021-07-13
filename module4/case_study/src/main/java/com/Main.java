package com;

import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.parse("2003-07-12");
        System.out.println( Period.between(birthDate, currentDate).getYears());

    }
}
