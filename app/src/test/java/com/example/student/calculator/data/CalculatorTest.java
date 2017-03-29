package com.example.student.calculator.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jittat on 30/3/2560.
 */

public class CalculatorTest {
    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void shouldReturnZeroAfterReset() {
        calculator.reset();
        assertEquals(0, calculator.getResult());
    }

    @Test
    public void shouldReturnValueAfterSet() {
        calculator.reset();
        calculator.setResult(1234);
        assertEquals(1234, calculator.getResult());
    }

    @Test
    public void shouldAddTwoNumbers() {
        calculator.reset();
        calculator.setResult(1234);
        assertEquals(1334, calculator.operate(calculator.OPERATOR_ADD,100));
    }

    @Test
    public void shouldAddThreeNumbers() {
        calculator.reset();
        calculator.setResult(1234);
        calculator.operate(calculator.OPERATOR_ADD,100);
        assertEquals(1834, calculator.operate(calculator.OPERATOR_ADD,500));
    }
}
