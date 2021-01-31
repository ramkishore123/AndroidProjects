package com.example.registerationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toast.makeText(this,"welcome to login page", Toast.LENGTH_SHORT).show();

        userName= findViewById(R.id.et_userName);
        password=findViewById(R.id.et_password);

        Intent intent = getIntent();
        String name = intent.getStringExtra("userName");
        userName.setText(name);

    }

    public void loginBtnClicked(View view) {

        String UserName = userName.getText().toString();
        String Password = password.getText().toString();

        if(UserName.isEmpty() && Password.isEmpty()){

            Toast.makeText(LoginActivity.this, "Non authorized user", Toast.LENGTH_SHORT).show();
        }

         else {

            Intent intent = new Intent(LoginActivity.this, Home.class);
            startActivity(intent);
        }
    }
}
