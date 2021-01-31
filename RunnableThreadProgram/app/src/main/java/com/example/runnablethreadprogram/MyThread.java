package com.example.runnablethreadprogram;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

import com.example.runnablethreadprogram.model.Employee;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyThread extends Thread {


    private static final String TAG="MyThread";


    Boolean isRunning=true;

    Employee employee;
    public MyThread(Employee email) {
        this.employee=email;
    }

    @Override
    public void run() {
        super.run();

        while(isRunning){

            try{

                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:MM:ss", Locale.getDefault());

            Date date= new Date();

            String currentTime=simpleDateFormat.format(date);

            Message message= new Message();

            Bundle bundle= new Bundle();
            bundle.putString("time",currentTime);
            message.setData(bundle);

          try{
              synchronized (employee){

                  Log.d(TAG, "run: myThread waits");
                  Log.d(TAG, "run: "+employee.getSenderName());

                  employee.wait();
              }
          } catch (InterruptedException e) {
              e.printStackTrace();
          }


        }
    }
}
