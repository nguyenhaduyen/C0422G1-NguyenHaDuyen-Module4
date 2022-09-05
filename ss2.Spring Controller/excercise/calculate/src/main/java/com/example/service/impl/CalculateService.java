package com.example.service.impl;

import com.example.service.ICalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateService implements ICalculateService {
    @Override
    public String calculate(String number1, String number2, String operand) {
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        String result = "";
        switch (operand) {
            case "addition":
                result = num1 + num2 + "";
                break;
            case "subtraction":
                result = num1 - num2 + "";
                break;
            case "multiplication":
                result = num1 * num2 + "";
                break;
            case "division":
                if (num2 == 0) {
                    result = "Number 2 can not be 0";
                } else {
                    result = num1 / num2 + "";
                }
                break;
        }
        return result;
    }
}

