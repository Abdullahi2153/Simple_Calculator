package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private Button one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, multiply, division, equal, clear;

    private Integer firstInput = 0, secondInput = 0;
    private boolean isAdd, isSub, isMult, isDiv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        textViewResult = findViewById(R.id.textViewResult);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        division = findViewById(R.id.div);
        equal = findViewById(R.id.equal);
        clear = findViewById(R.id.clear);



        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textViewResult.getText().toString().length() != 0){
                    firstInput = Integer.valueOf(textViewResult.getText().toString());
                    isAdd = true;
                    textViewResult.setText(null);
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textViewResult.getText().toString().length() != 0){
                    firstInput = Integer.valueOf(textViewResult.getText().toString());
                    isSub = true;
                    textViewResult.setText(null);
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textViewResult.getText().toString().length() != 0){
                    firstInput = Integer.valueOf(textViewResult.getText().toString());
                    isMult = true;
                    textViewResult.setText(null);
                }
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textViewResult.getText().toString().length() != 0){
                    firstInput = Integer.valueOf(textViewResult.getText().toString());
                    isDiv = true;
                    textViewResult.setText(null);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    firstInput = 0;
                    secondInput = 0;
                    textViewResult.setText("");

            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isAdd || isSub || isMult || isDiv){
                    secondInput = Integer.valueOf(textViewResult.getText().toString());
                }


               if (isAdd){
                   textViewResult.setText(firstInput+secondInput+"");
                   isAdd = false;
               }

                if (isSub){
                    textViewResult.setText(firstInput-secondInput+"");
                    isSub = false;
                }

                if (isMult){
                    textViewResult.setText(firstInput*secondInput+"");
                    isMult = false;
                }

                if (isDiv){
                    if (secondInput > 0){
                        double result = firstInput/secondInput;
                        textViewResult.setText(String.format("%.2f", result));
                        isDiv = false;
                    }else {
                        Toast.makeText(MainActivity.this, "Second Input should be greater than zero", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });


    }

    public void numberOperation(View view) {
        Button button = (Button) view;
        textViewResult.setText(textViewResult.getText().toString()+button.getText().toString());
    }


}