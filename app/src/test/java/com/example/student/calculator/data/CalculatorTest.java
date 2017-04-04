package com.example.student.calculator.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void shouldSubtractTwoNumber(){
        calculator.reset();
        calculator.setResult(1000);
        calculator.operate(calculator.OPERATOR_SUB,50);
        assertEquals(950,calculator.getResult());
    }

    @Test
    public void shouldMultipleTwoNumber(){
        calculator.reset();
        calculator.setResult(100);
        calculator.operate(calculator.OPERATOR_MUL,9);
        assertEquals(900,calculator.getResult());
    }

    @Test
    public void shouldMultipleThreeNumber(){
        calculator.reset();
        calculator.setResult(5);
        calculator.operate(calculator.OPERATOR_MUL,10);
        assertEquals(450,calculator.operate(calculator.OPERATOR_MUL,9));
    }

    @Test
    public void shouldDivideTwoNumber(){
        calculator.reset();
        calculator.setResult(999);
        calculator.operate(calculator.OPERATOR_DIV,9);
        assertEquals(111,calculator.getResult());
    }

    @Test
    public void shouldReturnErrorWhenDivideByZero(){
        calculator.reset();
        calculator.setResult(1);
        calculator.operate(calculator.OPERATOR_DIV,0);
        assertTrue(calculator.isError());
    }

    @Test
    public void shouldReturnErrorFalseWhenDivideByNumberNotZero(){
        calculator.reset();
        calculator.setResult(6);
        calculator.operate(calculator.OPERATOR_DIV,3);
        assertFalse(calculator.isError());
    }

    @Test
    public void shouldKeepErrorStateUntilReset(){
        calculator.reset();
        assertFalse(calculator.isError());

        calculator.setResult(1);
        calculator.operate(calculator.OPERATOR_DIV,0);
        assertTrue(calculator.isError());

        calculator.reset();
        assertFalse(calculator.isError());

    }


}
