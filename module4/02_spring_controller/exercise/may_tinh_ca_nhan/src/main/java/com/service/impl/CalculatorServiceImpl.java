package com.service.impl;

import org.springframework.stereotype.Service;
import com.service.ICalculatorService;
@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public double calculator(String calculator, double num1, double num2) {
        double result=0;
        switch (calculator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }
}
