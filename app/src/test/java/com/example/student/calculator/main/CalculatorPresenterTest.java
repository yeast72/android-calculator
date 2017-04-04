package com.example.student.calculator.main;

import com.example.student.calculator.data.Calculator;
import com.example.student.calculator.main.CalculatorPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

/**
 * Created by jittat on 29/3/2560.
 */

public class CalculatorPresenterTest {
    private CalculatorPresenter presenter;

    @Mock
    CalculatorView view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Calculator calculator = new Calculator();
        presenter = new CalculatorPresenter(calculator,view);
        presenter.reset();
    }

    @Test
    public void shouldShowZeroAfterReset() {

        verify(view).setCalculatorResult("0");
    }

    @Test
    public void shouldShowSingleDigitNumber() {
        presenter.onNumberClick(5);

        verify(view).setCalculatorResult("5");
    }

    @Test
    public void shouldShowTwoDigitNumber() {
        presenter.onNumberClick(5);
        presenter.onNumberClick(7);

        InOrder order = inOrder(view);

        order.verify(view).setCalculatorResult("0");
        order.verify(view).setCalculatorResult("5");
        order.verify(view).setCalculatorResult("57");


    }
    @Test
    public void shouldAddThreeNumber(){
        presenter.onNumberClick(8);
        presenter.onOpClick(CalculatorPresenter.OPERATOR_ADD);
        presenter.onNumberClick(5);
        presenter.onOpClick(CalculatorPresenter.OPERATOR_EQ);

        InOrder order = inOrder(view);

        order.verify(view).setCalculatorResult("0");
        order.verify(view).setCalculatorResult("8");
        order.verify(view).setCalculatorResult("");
        order.verify(view).setCalculatorResult("5");
        order.verify(view).setCalculatorResult("13");

        presenter.onOpClick(CalculatorPresenter.OPERATOR_ADD);
        order.verify(view).setCalculatorResult("");
        presenter.onNumberClick(7);
        order.verify(view).setCalculatorResult("7");
        presenter.onOpClick(CalculatorPresenter.OPERATOR_EQ);
        order.verify(view).setCalculatorResult("20");

    }

    @Test
    public void shouldSubtrackThreeNumber(){
        presenter.onNumberClick(9);
        presenter.onNumberClick(9);
        presenter.onOpClick(CalculatorPresenter.OPERATOR_SUB);
        presenter.onNumberClick(5);
        presenter.onNumberClick(5);
        presenter.onOpClick(CalculatorPresenter.OPERATOR_EQ);

        InOrder order = inOrder(view);
        order.verify(view).setCalculatorResult("9");
        order.verify(view).setCalculatorResult("99");
        order.verify(view).setCalculatorResult("");
        order.verify(view).setCalculatorResult("5");
        order.verify(view).setCalculatorResult("55");
        order.verify(view).setCalculatorResult("44");

        presenter.onOpClick(CalculatorPresenter.OPERATOR_SUB);
        order.verify(view).setCalculatorResult("");
        presenter.onNumberClick(4);
        order.verify(view).setCalculatorResult("4");
        presenter.onOpClick(CalculatorPresenter.OPERATOR_EQ);
        order.verify(view).setCalculatorResult("40");

    }

    @Test
    public void shouldMultipleTwoNumber(){
        presenter.reset();
        presenter.onNumberClick(8);
        presenter.onNumberClick(0);
        presenter.onOpClick(CalculatorPresenter.OPERATOR_MUL);
        presenter.onNumberClick(2);
        presenter.onOpClick(CalculatorPresenter.OPERATOR_EQ);

        InOrder order = inOrder(view);
        order.verify(view).setCalculatorResult("8");
        order.verify(view).setCalculatorResult("80");
        order.verify(view).setCalculatorResult("");
        order.verify(view).setCalculatorResult("2");
        order.verify(view).setCalculatorResult("160");
    }

    @Test
    public void shouldDivideTwoNumber(){
        presenter.onNumberClick(7);
        presenter.onNumberClick(2);
        presenter.onOpClick(CalculatorPresenter.OPERATOR_DIV);
        presenter.onNumberClick(6);
        presenter.onOpClick(CalculatorPresenter.OPERATOR_EQ);

        InOrder order = inOrder(view);
        order.verify(view).setCalculatorResult("7");
        order.verify(view).setCalculatorResult("72");
        order.verify(view).setCalculatorResult("");
        order.verify(view).setCalculatorResult("6");
        order.verify(view).setCalculatorResult("12");
    }

    @Test
    public void shouldResetNumber(){
        InOrder order = inOrder(view);
        presenter.onNumberClick(2);
        order.verify(view).setCalculatorResult("2");
        presenter.onNumberClick(3);
        order.verify(view).setCalculatorResult("23");
        presenter.reset();
        order.verify(view).setCalculatorResult("0");
    }

    @Test
    public void shouldDeleteLastNumber(){
        InOrder order = inOrder(view);
        presenter.onNumberClick(8);
        order.verify(view).setCalculatorResult("8");
        presenter.onNumberClick(9);
        order.verify(view).setCalculatorResult("89");
        presenter.onBackClick();
        order.verify(view).setCalculatorResult("8");
        presenter.onNumberClick(1);
        order.verify(view).setCalculatorResult("81");
        presenter.onNumberClick(2);
        order.verify(view).setCalculatorResult("812");
        presenter.onBackClick();
        order.verify(view).setCalculatorResult("81");
        presenter.onBackClick();
        order.verify(view).setCalculatorResult("8");
    }

    @Test
    public void shouldDeleteNumberWhenOneDigit(){
        InOrder order = inOrder(view);
        presenter.onNumberClick(-4);
        order.verify(view).setCalculatorResult("-4");
        presenter.onBackClick();
        order.verify(view).setCalculatorResult("");
    }
}
