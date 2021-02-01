package com.example.calculatordemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;


public class Fragment2Demo extends Fragment {

    ImageView image;
    private TextView tv_title;

    public Fragment2Demo() {
        // Required empty public constructor
    }

      public static Fragment2Demo newInstance(String param1, String param2) {
        Fragment2Demo fragment = new Fragment2Demo();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_fragment2_demo, container, false);

            tv_title=view.findViewById(R.id.tv_fragment2_title);
       image= view.findViewById(R.id.img_fragement2);

       getParentFragmentManager().setFragmentResultListener("DATA_F1", this, new FragmentResultListener() {
           @Override
           public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
               String name = result.getString("name");
               Log.d("TAg", "onFragmentResult: "+name);
               tv_title.setText(name);
           }
       });
        return  view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
     }



     public void showImage(String uri){

         Picasso.get().load(uri).into(image);


     }


}
