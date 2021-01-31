package com.example.fibonacciapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button calculationButton;
    private int limit=0;

    MyAdapter adapter;



    RecyclerView recyclerView;

    private EditText et_text;

    private static final String TAG = "MainActivity";
    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculationButton = findViewById(R.id.btn_peromCalculation);

        et_text=findViewById(R.id.et_inputNumber);

        recyclerView=findViewById(R.id.rv_container);
    }


    public void fibonacciCalculation(View view) {

        //et.getText()=limit
        //thread .start();
        limit=Integer.parseInt(et_text.getText().toString());
        MyThread thread= new MyThread();
        thread.start();


        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter= new MyAdapter(new ArrayList());
        recyclerView.setAdapter(adapter);



    }

    class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
            fib(limit);

        }

        public  void fib(int n) {
            if(n>0){

            final int f[] = new int[n + 1];

            int i;
            f[0] = 0;
            f[1] = 1;
            for (i = 2; i <= n; i++) {
                f[i] = f[i - 1] + f[i - 2];
                ///handler .post array[i]
                Log.d(TAG, "fib: "+f[i]);
                final int finalI = i;
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        adapter.addItem(f[finalI]);
                    }
                });
            }
         }

        }
    }
}
