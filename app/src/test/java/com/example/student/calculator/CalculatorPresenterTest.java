package com.example.student.calculator;

import com.example.student.calculator.main.CalculatorPresenter;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by jittat on 29/3/2560.
 */

public class CalculatorPresenterTest {

    @Test
    public void createPresenterTest() {
        CalculatorPresenter presenter = new CalculatorPresenter();
        assertNotNull(presenter);
    }
}
