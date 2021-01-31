package com.example.sqllitedatabaseproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sqllitedatabaseproject.Adapter.MyAdapter;
import com.example.sqllitedatabaseproject.Model.Contact;

import java.util.List;


public class showContactsFragment extends Fragment {

   // private TextView tv_id,tv_name,tv_phoneNumber;

    private MyAdapter adapter;
    private RecyclerView recyclerView;

    List<Contact> contacts;

    public showContactsFragment() {
        // Required empty public constructor
    }

    public showContactsFragment(List<Contact> allContacts) {
        this.contacts=allContacts;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_show_contacts, container, false);

        recyclerView=view.findViewById(R.id.rv_container);

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());

        MyAdapter adapter= new MyAdapter(this.contacts,getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(dividerItemDecoration);
        return view;

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

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
