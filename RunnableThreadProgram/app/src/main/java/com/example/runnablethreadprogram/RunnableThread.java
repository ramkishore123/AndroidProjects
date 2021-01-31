package com.example.runnablethreadprogram;

import android.util.Log;

import com.example.runnablethreadprogram.model.Employee;

import static android.content.ContentValues.TAG;

public class RunnableThread implements Runnable {

    Employee employee;

   private static final String TAG="RunnableThread";

    public RunnableThread(Employee email) {
        this.employee=email;
    }

    @Override
    public void run() {

        for (int i=0; i<20; i++){


            try{
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(i%2==0){
                synchronized (employee){

                    Log.d(TAG, "run: email obj uses src in runnable");
                    Log.d(TAG, "run: "+employee.getSenderName());
                    employee.notify();
                }


            }
        }

    }
}
