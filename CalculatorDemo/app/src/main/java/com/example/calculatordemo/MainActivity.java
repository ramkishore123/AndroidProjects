package com.example.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.CollationElementIterator;

public class MainActivity extends AppCompatActivity {

    EditText values;
    Button bt1, bt2, bt3, bt4,bt5, bt6, bt7,bt8,bt9,bt0, add, multiply, divide, modulous, dot, clear, subtract, equals;
    String value1="0" ;
    Double result;
    Boolean isFirstValue;
    int operationKey;
    private TextView previous_result;
    private  TextView operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        values=findViewById(R.id.et_value);

        previous_result=findViewById(R.id.tv_previous_result);
        result=0D;
        bt1=findViewById(R.id.button1);
        bt2=findViewById(R.id.button2);
        bt3=findViewById(R.id.button3);
        bt4=findViewById(R.id.button4);
        bt5=findViewById(R.id.button5);
        bt6=findViewById(R.id.button6);
        bt7=findViewById(R.id.button7);
        bt8=findViewById(R.id.button8);
        bt9=findViewById(R.id.button9);
        bt0=findViewById(R.id.button0);
        add=findViewById(R.id.buttonAdd);
        subtract=findViewById(R.id.buttonSubtract);
        multiply=findViewById(R.id.buttonMultiply);
        modulous=findViewById(R.id.buttonModulous);
        divide=findViewById(R.id.buttonDivide);
        dot=findViewById(R.id.buttonDot);
        clear=findViewById(R.id.buttonClear);
        equals=findViewById(R.id.buttonEquals);
        values=findViewById(R.id.et_value);


        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("0");
                setValues(0);
            }
        };
        bt0.setOnClickListener(listener);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("1");
                setValues(1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("2");

                setValues(2);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("3");
                setValues(3);

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("4");
                setValues(4);

            }
        });


        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("5");

                setValues(5);
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("6");
                setValues(6);

            }
        });


        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("7");
                setValues(7);

            }
        });


        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("8");
                setValues(8);

            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("9");
                setValues(9);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("+");
                result= result+Double.valueOf(value1);
                //result value + ?    cannot resolve method?
                previous_result.setText(result+"");

            }
        });


        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("-");

                result=result-Double.valueOf(value1);
                previous_result.setText(result+"");

            }
        });



        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("*");
                result=result*Double.valueOf(value1);;
                previous_result.setText(result+"");

            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("/");
                result=result/Double.valueOf(value1);;


            }
        });


        modulous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("%");
                result=result%Double.valueOf(value1);;

            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText(".");


            }
        });


        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText("=");


            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values.setText(".");


            }
        });
    }


    //we use bottom method to make the single digit to double digit
    private void setValues(int i) {
        //value1 is string and we concatenate another value in string format

        //intial value1 value is 0 then the result could be 03(if button 3 is clicked )
        value1+= String.valueOf(i);
        values.setText(""+result);
    }


}
