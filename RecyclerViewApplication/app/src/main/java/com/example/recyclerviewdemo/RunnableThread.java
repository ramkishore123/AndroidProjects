package com.example.recyclerviewdemo;


import android.os.Handler;
import android.util.Log;

import com.example.recyclerviewdemo.model.Email;

//second way to create a thread
public class RunnableThread implements Runnable {

    static final String TAG ="RunnableThread";
    private final Email email;

    public RunnableThread(  Email email) {
        this.email=email;
    }

    @Override
    public void run() {
        for (int i=0;i<20;i++){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "run: "+i);
            if (i%2==0) {
                synchronized (email) {
                    Log.d(TAG, "run: email obj uses src in runnable");
                    Log.d(TAG, "run: "+email.getSenderName());
                    email.notify();
                }
            }
        }



    }
}
