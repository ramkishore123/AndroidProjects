package com.example.recyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import com.example.recyclerviewdemo.model.Email;

public class ThreadDemoActivity extends AppCompatActivity {

    TextView message;
    static final String TAG = "ThreadDemoActivity";
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_demo);
        Log.d(TAG, "onCreate: Main thread");
        //threads 2 types  in android
        //1 st thread type is Main thread
        //2nd type is  background thread.
        //Main thread responsible for draw and  maintain views and ui
        //Main thread will be automatically created when app opens and will be destrooyed when app is closed
        //background thread is for  cpu intesive work  like network request,db operations,file reading or writing,bitmaap creating.

        message = findViewById(R.id.tv_counter);

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                message.setText(msg.getData().getString("time"));
            }
        };
        createThread();
        Log.d(TAG, "onCreate: Main thread after calling background thread");


    }

    void createThread() {
        Log.d(TAG, "createThread:Main thread ");
        Email email=new Email("nag","empty");
        MyThread thread = new MyThread(handler,email);
        thread.start();

        Thread thread1 = new Thread(new RunnableThread( email));
        thread1.start();





         // thread.setIsRunning(false);

    }
}
