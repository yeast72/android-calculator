package com.example.student.calculator.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.student.calculator.R;

public class MainActivity extends AppCompatActivity implements CalculatorView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
