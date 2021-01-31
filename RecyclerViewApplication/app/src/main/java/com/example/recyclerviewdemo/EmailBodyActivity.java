package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.recyclerviewdemo.model.Email;

import java.io.Serializable;

public class EmailBodyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_body);
        Intent intent = getIntent();
        Email email_obj = (Email) intent.getSerializableExtra("email_obj");
        Log.d("EmailBodyActivity", "onCreate: "+email_obj.getSenderName());
        Log.d("EmailBodyActivity", "onCreate: "+email_obj.getSubject());
    }
}
