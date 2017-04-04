package com.example.student.calculator.main;

import com.example.student.calculator.data.Calculator;

/**
 * Created by jittat on 29/3/2560.
 */

public class CalculatorPresenter {
    private CalculatorView view;
    private Calculator calculator;
    private int operate;
    private int firstNumber;
    private int secondNumber;

    public static final int OPERATOR_ADD = Calculator.OPERATOR_ADD;
    public static final int OPERATOR_SUB = Calculator.OPERATOR_SUB;
    public static final int OPERATOR_MUL = Calculator.OPERATOR_MUL;
    public static final int OPERATOR_DIV = Calculator.OPERATOR_DIV;
    public static final int OPERATOR_EQ = 5;

    public CalculatorPresenter(Calculator calculator, CalculatorView view) {
        this.calculator = calculator;
        this.firstNumber = 0;
        this.secondNumber = 0;
        this.operate = 0;
        this.view = view;
    }

    public void reset() {
        calculator.reset();
        this.firstNumber = 0;
        this.secondNumber = 0;
        this.operate = 0;
        view.setCalculatorResult(calculator.getResult() + "");
    }

    public void onNumberClick(int num) {
        if(calculator.getResult() != 0) {
            calculator.setResult(Integer.parseInt(calculator.getResult()+""+num));
        }else{
            calculator.setResult(num);
        }
        System.out.println(calculator.getResult());
        view.setCalculatorResult(calculator.getResult() + "");
    }

    public void onOpClick(int op) {
        if (op == OPERATOR_EQ) {
            secondNumber = calculator.getResult();
            calculator.setResult(firstNumber);
            calculator.operate(operate,secondNumber);
            view.setCalculatorResult(calculator.getResult()+"");
            System.out.print(calculator.getResult());
        }
        else{
            firstNumber = calculator.getResult();
            operate = op;
            calculator.setResult(0);
            view.setCalculatorResult("");

        }
    }

    public void onResetClick() {
       reset();
    }

    public void onBackClick() {
        String number = calculator.getResult() + "";
        if(number.length() <= 1 || (number.length() <= 2 && calculator.getResult() < 0)){
            calculator.setResult(0);
            view.setCalculatorResult("");
        }
        else {
            number = number.substring(0, number.length() - 1);
            calculator.setResult(Integer.parseInt(number));
            view.setCalculatorResult(number);
        }
    }
}
