package com.example.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

public class FragmentDemo extends AppCompatActivity implements IFragmentClickListener{

    private Fragment1Demo fragment1Demo;
    private Fragment2Demo fragment2Demo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        addFragment1();
        addFragment2();

    }


    public void addFragment(View view) {
        ///step 1 create fragement manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //step 2 create fragement transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //step 3 create fragement object  and for sending data from fragment to parent we need to pass parent object in fragment object
        fragment1Demo = new Fragment1Demo(FragmentDemo.this);
        //step 4 adding fragment obj into container
        fragmentTransaction.add(R.id.container1, fragment1Demo, "F1Demo");
        //step 5 saving the change of fragment transaction
         fragmentTransaction.commit();

    }

    public void removeFragment(View view) {
        if (fragment1Demo != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment1Demo);
            fragmentTransaction.commit();
        }
    }

    public void sendTime(View view) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        String currentTime = simpleDateFormat.format(date);
        if (fragment1Demo!=null){
            fragment1Demo.showTime(currentTime);
        }

    }

    public void addFragment2(View view) {
     //step1 create fragment  manager
        FragmentManager fragmentManager= getSupportFragmentManager();
      //create transaction manager
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
     //step 3 create fragement 2 object
        fragment2Demo = new Fragment2Demo();
       //step 4 add the fragment to the container(framelayout)

       fragmentTransaction.add(R.id.container1,fragment2Demo,"Fragment2");
     //step 5
       fragmentTransaction.commit();
    }

    public void sendImage(View view) {

        if(fragment2Demo !=null){
            fragment2Demo.showImage("https://picsum.photos/200");
        }



    }

    @Override
    public void sendDataToActivity(String data) {
        Toast.makeText(FragmentDemo.this,data,Toast.LENGTH_SHORT).show();
    }


    public void addFragment1(){
        ///step 1 create fragement manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //step 2 create fragement transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //step 3 create fragement object  and for sending data from fragment to parent we need to pass parent object in fragment object
        fragment1Demo = new Fragment1Demo(FragmentDemo.this);
        //step 4 adding fragment obj into container
        fragmentTransaction.add(R.id.container1, fragment1Demo, "F1Demo");
        //step 5 saving the change of fragment transaction
        fragmentTransaction.commit();



    }

    public void addFragment2(){


        //step1 create fragment  manager
        FragmentManager fragmentManager= getSupportFragmentManager();
        //create transaction manager
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        //step 3 create fragement 2 object
        fragment2Demo = new Fragment2Demo();
        //step 4 add the fragment to the container(framelayout)

        fragmentTransaction.add(R.id.container2,fragment2Demo,"Fragment2");
        //step 5
        fragmentTransaction.commit();

    }


}
