package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    ImageView btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_ac,btn_module,btn_minus,btn_plus,btn_multiply,btn_equal,btn_extra,btn_dot;
    TextView inputTxt,outputTxt;
    String ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_ac = findViewById(R.id.btn_ac);
        btn_module = findViewById(R.id.btn_module);
        btn_minus = findViewById(R.id.btn_minus);
        btn_plus = findViewById(R.id.btn_plus);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_equal = findViewById(R.id.btn_equal);
        btn_extra = findViewById(R.id.btn_extra);
        btn_dot=findViewById(R.id.btn_dot);

        inputTxt = findViewById(R.id.inputTxt);
        outputTxt = findViewById(R.id.outputTxt);


        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"0");
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"6");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"7");
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"9");
            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputTxt.setText("");
                outputTxt.setText("");

            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+".");

            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"+");

            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"-");

            }
        });
        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"x");

            }
        });
        btn_extra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"/");

            }
        });
        btn_module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ans = inputTxt.getText().toString();
                inputTxt.setText(ans+"%");

            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans = inputTxt.getText().toString();
                ans=ans.replaceAll("x","*");
                ans=ans.replaceAll("%","/100");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String result = "";
                Scriptable scriptable = rhino.initStandardObjects();

                result=rhino.evaluateString(scriptable,ans,"JavaScript",1,null).toString();

                outputTxt.setText(result);

            }
        });



    }
}