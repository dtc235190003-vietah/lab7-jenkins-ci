package com.devops.lab7;

/**
 * Provides basic arithmetic operations.
 */
public class Calculator {

    public double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double subtract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public double divide(double dividend, double divisor) {
        if (divisor == 0.0) {
            throw new IllegalArgumentException("Divisor must not be zero");
        }
        return dividend / divisor;
    }

    public boolean isPositive(double number) {
        return number > 0.0;
    }
}
