package com.example.registerationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    EditText UserName,Email, Password, ConfirmPassword;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toast.makeText(this,"welcome to Registeration page", Toast.LENGTH_SHORT).show();

        UserName=findViewById(R.id.et_userName);
        Email=findViewById(R.id.et_password);
        Password=findViewById(R.id.et_password);
        ConfirmPassword=findViewById(R.id.et_Cpassword);
        Register=findViewById(R.id.btn_Registeration);
    }

    public void registerBtnClicked(View view) {
        String userName = UserName.getText().toString();
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        String cPassword = ConfirmPassword.getText().toString();

        if(userName.isEmpty() && email.isEmpty() && password.isEmpty() && cPassword.isEmpty()){

            Toast.makeText(RegistrationActivity.this, "Please fill the details", Toast.LENGTH_SHORT).show();
        }

        else{
            Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
            intent.putExtra("userName", userName);
            startActivity(intent);
        }
    }
}
