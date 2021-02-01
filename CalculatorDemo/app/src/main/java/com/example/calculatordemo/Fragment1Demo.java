package com.example.calculatordemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

import static android.content.ContentValues.TAG;


public class Fragment1Demo extends Fragment {

    private TextView title;
   // private  static final TAG="Fragment1Demo";

    public Fragment1Demo() {
        // Required empty public constructor
    }
    private  IFragmentClickListener listener; //has a

    public Fragment1Demo(IFragmentClickListener fragmentDemo) {
        this.listener=fragmentDemo;
    }


    public static Fragment1Demo newInstance(String param1, String param2) {
        Fragment1Demo fragment = new Fragment1Demo();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: Oncreate method called");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: OncreateView method called");
         // Inflate the layout for this fragment
        //inflate binds the fragment layout to container in main activity and the root is false bcz it can be added/removed from main activity
        View view = inflater.inflate(R.layout.fragment_fragment1_demo, container, false);
         title = view.findViewById(R.id.et_fragment1_title);
        View btn_sendData = view.findViewById(R.id.btn_sendData_to_activity);
        btn_sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.sendDataToActivity("this Data is from fragment 1");
                String data = title.getText().toString();
                //create bundle to pass data from fragment
                Bundle bundle=new Bundle();
                bundle.putString("name",data);
                getParentFragmentManager().setFragmentResult("DATA_F1",bundle);
              }
        });
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d(TAG, "onActivity: OnActivity method called");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.d(TAG, "onAttach: OnAttach method called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: OnDetatch method called");

    }

    public void showTime(String currentTime) {

        title.setText(currentTime);
    }
}
