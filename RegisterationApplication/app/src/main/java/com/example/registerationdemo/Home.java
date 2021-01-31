package com.example.registerationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    EditText number1, number2;
    Button add, subtract, multiply, division;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toast.makeText(Home.this, "welcome to Home Activity", Toast.LENGTH_SHORT).show();

        number1=findViewById(R.id.et_number1);
        number2=findViewById(R.id.et_number2);
        add=findViewById(R.id.btn_add);
        subtract=findViewById(R.id.btn_subtract);
        multiply=findViewById(R.id.btn_multiply);
        division=findViewById(R.id.btn_division);
        result=findViewById(R.id.tv);
    }



    public void divisionBtnClicked(View view) {

        String Number1 = number1.getText().toString();
        int value1 = Integer.parseInt(Number1);

        String Number2 = number2.getText().toString();
        int value2 = Integer.parseInt(Number2);

        int data=value1/value2;
        result.setText("Division is:"+data);
    }

    public void multiplyBtnClicked(View view) {
        String Number1 = number1.getText().toString();
        int value1 = Integer.parseInt(Number1);

        String Number2 = number2.getText().toString();
        int value2 = Integer.parseInt(Number2);

        int data=value1*value2;
        result.setText("Multiplication result is:"+data);
    }

    public void subtractBtnClicked(View view) {
        String Number1 = number1.getText().toString();
        int value1 = Integer.parseInt(Number1);

        String Number2 = number2.getText().toString();
        int value2 = Integer.parseInt(Number2);

        int data=value1-value2;
        result.setText("subtraction result is:"+data);
    }

    public void addBtnClicked(View view) {
        String Number1 = number1.getText().toString();
        int value1 = Integer.parseInt(Number1);

        String Number2 = number2.getText().toString();
        int value2 = Integer.parseInt(Number2);

        int data=value1+value2;
        result.setText("Sum is:"+data);
    }

    public void logoutBtnClicked(View view) {

        Intent intent = new Intent(Home.this, MainActivity.class);
        startActivity(intent);
    }
}
