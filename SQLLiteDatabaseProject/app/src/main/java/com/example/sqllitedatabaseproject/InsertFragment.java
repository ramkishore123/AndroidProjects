package com.example.sqllitedatabaseproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.sqllitedatabaseproject.Database.DatabaseHandler;
import com.example.sqllitedatabaseproject.Model.Contact;


public class InsertFragment extends Fragment {

    private EditText et_id,et_name,et_phoneNumber;

    private static final String TAG = "InsertFragment";

    private IonShowItemClickListner listner;

    DatabaseHandler db;

    public InsertFragment() {
        // Required empty public constructor
    }

    public InsertFragment(DatabaseHandler db, IonShowItemClickListner listner) {
        this.db=db;
        this.listner=listner;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: entered to fragment");

        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_insert, container, false);
       //et_id=view.findViewById(R.id.et_id);

        Button btn=view.findViewById(R.id.btn_insert);
        Button btn1=view.findViewById(R.id.btn_showAllContacts);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listner.showAllContacts();


            }
        });


       et_name=view.findViewById(R.id.et_name);
       et_phoneNumber=view.findViewById(R.id.et_phoneNumber);

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               // int id= Integer.parseInt(et_id.getText().toString());
               String name=et_name.getText().toString();
               String phoneNumber=et_phoneNumber.getText().toString();

               Log.d(TAG, "onCreateView: "+name);
               Log.d(TAG, "onCreateView: "+phoneNumber);

               //Contact c= new Contact(name,phoneNumber);
               db.addContact(new Contact(name,phoneNumber));





           }
       });



       return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
