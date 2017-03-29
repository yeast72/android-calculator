package com.example.student.calculator.main;

import com.example.student.calculator.data.Calculator;

/**
 * Created by jittat on 29/3/2560.
 */

public class CalculatorPresenter {
    private CalculatorView view;
    private Calculator calculator;

    public static final int OPERATOR_ADD = Calculator.OPERATOR_ADD;
    public static final int OPERATOR_SUB = Calculator.OPERATOR_SUB;
    public static final int OPERATOR_MUL = Calculator.OPERATOR_MUL;
    public static final int OPERATOR_DIV = Calculator.OPERATOR_DIV;
    public static final int OPERATOR_EQ = 5;

    public CalculatorPresenter(Calculator calculator, CalculatorView view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void reset() {
        calculator.reset();
        view.setCalculatorResult(calculator.getResult());
    }

    public void onNumberClick(int num) {
        calculator.setResult(num);
        view.setCalculatorResult(num);
    }

    public void onOpClick(int op) {
        view.setCalculatorResult(op);
    }
}
