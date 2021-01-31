package com.example.runnablethreadprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;

import com.example.runnablethreadprogram.model.Employee;

public class MainActivity extends AppCompatActivity {

    Employee employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createThread();
    }




    void createThread(){

        Employee email=new Employee("johnsnow","empty");

        MyThread thread= new MyThread(email);

        thread.start();


        RunnableThread runnableThread= new RunnableThread(email);

        Thread thread1= new Thread(runnableThread);

        thread1.start();


    }
}
