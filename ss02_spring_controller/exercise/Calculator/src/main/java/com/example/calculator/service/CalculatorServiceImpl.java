package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService{
    @Override
    public int calculate(int firstOperator, int secondOperator, String operator) {
        int result = 0;
        switch (operator) {
            case "Add":
                result = firstOperator + secondOperator;
                break;
            case "Sub":
                result = firstOperator - secondOperator;
                break;
            case "Multi":
                result = firstOperator * secondOperator;
                break;
            case "Div":
                try {
                    result = firstOperator / secondOperator;
                } catch (ArithmeticException e) {
                    e.printStackTrace();
                }
        }
        return result;
    }
}
