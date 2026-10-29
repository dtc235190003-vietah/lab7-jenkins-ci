package com.devops.lab7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void addReturnsSum() {
        assertEquals(7.0, calculator.add(3.0, 4.0));
        assertEquals(-1.0, calculator.add(-3.0, 2.0));
    }

    @Test
    void subtractReturnsDifference() {
        assertEquals(6.0, calculator.subtract(10.0, 4.0));
        assertEquals(-5.0, calculator.subtract(-3.0, 2.0));
    }

    @Test
    void multiplyReturnsProduct() {
        assertEquals(12.0, calculator.multiply(3.0, 4.0));
        assertEquals(0.0, calculator.multiply(8.0, 0.0));
    }

    @Test
    void divideReturnsQuotient() {
        assertEquals(2.5, calculator.divide(10.0, 4.0));
        assertEquals(-3.0, calculator.divide(9.0, -3.0));
    }

    @Test
    void divideByZeroThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10.0, 0.0)
        );
        assertEquals("Divisor must not be zero", exception.getMessage());
    }

    @Test
    void isPositiveIdentifiesOnlyNumbersGreaterThanZero() {
        assertTrue(calculator.isPositive(0.01));
        assertFalse(calculator.isPositive(0.0));
        assertFalse(calculator.isPositive(-0.01));
    }
}
