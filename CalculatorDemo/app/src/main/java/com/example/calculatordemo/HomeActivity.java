package com.example.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity" ;

    //called when the activity object is created
    //first method to be called in activity life cycle
    //called only one time in whole activity lifecycle
    //to init resources we can use this method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: we are in oncreate method");
        Toast.makeText(HomeActivity.this,"currently on oncreate method", Toast.LENGTH_SHORT).show();



    }


    //called when app comes to foreground
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: we are in onstart method");
        Toast.makeText(HomeActivity.this,"currently on OnStart method", Toast.LENGTH_SHORT).show();


    }

    //called when app ui lost its focus
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "OnPause: we are in OnPause method");
        Toast.makeText(HomeActivity.this,"currently on onPause method", Toast.LENGTH_SHORT).show();


    }

    //called when app ui is ready to interact with user
    //if the app is active then it will be on onresume state
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "OnResume: we are in onResume method");
        Toast.makeText(HomeActivity.this,"currently on onResume method", Toast.LENGTH_SHORT).show();


    }

    //called when the app is went to background
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "OnStop: we are in OnStop method");
        Toast.makeText(HomeActivity.this,"currently on onStop method", Toast.LENGTH_SHORT).show();


    }

    //called when the activity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "OnDestroy: we are in onDestroy method");
        Toast.makeText(HomeActivity.this,"currently on OnDestroy method", Toast.LENGTH_SHORT).show();


    }

    //when uses retruns to the app from background
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "OnRestart: we are in OnRestart method");
        Toast.makeText(HomeActivity.this,"currently on OnRestart method", Toast.LENGTH_SHORT).show();


    }
}
