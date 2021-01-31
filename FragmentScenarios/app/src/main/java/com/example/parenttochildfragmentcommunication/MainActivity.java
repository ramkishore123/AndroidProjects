package com.example.parenttochildfragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private  BlankFragment1 blankFragment1;
    private Button data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data=findViewById(R.id.btn_sendDataToFragment);
    }

    public void addFragment1(View view) {

        FragmentManager fragmentManager= getSupportFragmentManager();

        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        BlankFragment1 blankFragment1= new BlankFragment1();

        fragmentTransaction.add(R.id.contaier, blankFragment1);


        fragmentTransaction.commit();
    }

    public void sendDataToFragment(View view) {

        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

        Date date= new Date();

        String Ctime=simpleDateFormat.format(date);

        blankFragment1.showData(Ctime);
    }

    public void sendImageToFragment(View view) {
    }
}
