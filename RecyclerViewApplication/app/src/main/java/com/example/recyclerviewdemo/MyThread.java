package com.example.recyclerviewdemo;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.recyclerviewdemo.model.Email;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//1st way to create a thread
public class MyThread  extends  Thread {

    static final String TAG="MyThread";

    Boolean isRunning=true;
    Handler handler;
    int counter=0;
    Email email;

    public MyThread(Handler handler, Email email) {
    this.handler=handler;
    this.email=email;

    }

    @Override
    public void run() {
        super.run();

       while (isRunning){
            try {

                //we wait the thread to run after the main thread runs. ui takes 16ms to open and
                //we keep the thread to wait for 1000ms i.e 1s bcz we donot want to start thread before the ui/main thread
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date date=new Date();
            String dateFormat=new SimpleDateFormat("HH:MM:SS", Locale.getDefault()).format(date);
            //create Message class object
            Message  m=new Message();
            Bundle bundle=new Bundle();
            bundle.putString("time",dateFormat);
            m.setData(bundle);
           Log.d(TAG, "run: "+dateFormat);
            //handler.sendMessage(m);

           try {
               synchronized (email){
                   Log.d(TAG, "run: myThread waits");
                   Log.d(TAG, "run: "+email.getSenderName());
                  email.wait();
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           //handler.sendMessageDelayed(m,1000);
         }
        Log.d(TAG, "run:background thread Ended");
    }
    public void setIsRunning(boolean isRunning){
        this.isRunning=isRunning;
    }
}

