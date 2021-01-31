package com.example.sqllitedatabaseproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqllitedatabaseproject.Database.DatabaseHandler;
import com.example.sqllitedatabaseproject.Model.Contact;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity  implements IonShowItemClickListner{

    private static final String TAG = "MainActivity";
    private Button btn_addfragment, btn_showContactsFragment;

    private InsertFragment fragmentInsert;
    private  showContactsFragment showContactsFragment;

    private MyChargingNotifier myChargingNotifier;
    private TextView name,phoneNumber;

    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         db= new DatabaseHandler(this, "contactsManager", null, 1);


        name=findViewById(R.id.tv_name);
        phoneNumber=findViewById(R.id.tv_phoneNumber);

        myChargingNotifier= new MyChargingNotifier();
        IntentFilter intentFilter= new IntentFilter();
        intentFilter.addAction("SELECTEDROW");
        registerReceiver(myChargingNotifier,intentFilter);

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentInsert=new InsertFragment(db,MainActivity.this);
        fragmentTransaction.add(R.id.container,fragmentInsert,"insertFragment");
        fragmentTransaction.commit();




//        btn_addfragment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager fragmentManager=getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                fragmentInsert=new InsertFragment(db,MainActivity.this);
//                fragmentTransaction.add(R.id.container,fragmentInsert,"insertFragment");
//                fragmentTransaction.commit();
//
//            }
//        });


//        btn_showContactsFragment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                FragmentManager fragmentManager=getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                showContactsFragment=new showContactsFragment();
////               fragmentTransaction.remove(fragmentInsert);
//                fragmentTransaction.replace(R.id.container,showContactsFragment,"showContactsFragment");
//                fragmentTransaction.commit();
//
//
//            }
//        });
    }

    @Override
    public void showAllContacts() {
        List<Contact> allContacts = db.getAllContacts();
        if(allContacts!=null && !allContacts.isEmpty()){
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            showContactsFragment=new showContactsFragment(allContacts);
//               fragmentTransaction.remove(fragmentInsert);
            fragmentTransaction.replace(R.id.container,showContactsFragment,"showContactsFragment");
            fragmentTransaction.commit();
        }
        else{
            Toast.makeText(getApplicationContext(),"no records found",Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(myChargingNotifier);
    }


    //create broadcast class to listen onItemClick recyclerview MYADAPTER CLASS


    class MyChargingNotifier extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("SELECTEDROW")) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String id= intent.getStringExtra("id");
                    Log.d(TAG, "onReceive: "+ id);
                    String text=intent.getStringExtra("name");
                    Log.d(TAG, "onReceive: "+text);
                    String text1=intent.getStringExtra("phoneNumber");
                    Log.d(TAG, "onReceive: "+text1);
                    //TODO replace fragment with uodate fragment and send the received details to update fragment
                    //TODO IN update fragment use can chnage the user name and ohjne number but not user id
                    //TODO whENER USE CLICKS ON UPDATE BUTTON inside update fragment we have to update the user details according to user id
                    //TODO after updting user details we have to comeback to main activit to show the list of contacts

                    name.setText( text);


                    phoneNumber.setText(text1);

                }
                }



        }
    }



}
