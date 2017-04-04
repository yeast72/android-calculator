package com.example.student.calculator.data;

/**
 * Created by jittat on 30/3/2560.
 */

public class Calculator {
    private int result;
    private boolean errorOccur;

    public static final int OPERATOR_ADD = 1;
    public static final int OPERATOR_SUB = 2;
    public static final int OPERATOR_MUL = 3;
    public static final int OPERATOR_DIV = 4;


    public Calculator() {
        reset();
    }

    public void reset() {
        result = 0;
        errorOccur = false;
    }

    public int setResult(int r) {
        result = r;
        return result;
    }

    public int operate(int op, int a) {
        switch(op) {
            case OPERATOR_ADD:
                result += a;
                break;
            case OPERATOR_SUB:
                result -= a;
                break;
            case OPERATOR_MUL:
                result *= a;
                break;
            case OPERATOR_DIV:
                if(a != 0) {
                    result /= a;
                    errorOccur = false;
                }else{
                    errorOccur = true;
                    return 0;
                }
                break;
        }
        return result;
    }

    public boolean isError() {
        return errorOccur;
    }

    public int getResult() {
        return result;
    }

}
