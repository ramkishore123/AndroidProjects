package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.recyclerviewdemo.model.Email;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IRecyclerViewItemClickListener {

    //java object to get recycler view from xml
    RecyclerView recyclerView;
    MyAdapter adapter;
    private ArrayList<Email> list;
    private ArrayList<String> currency_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void loadList(View view) {

        recyclerView = findViewById(R.id.rv_list);
        //we need to set orientation for the recycler view, it contains where to display and how to display
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), 1));
        //Collections list ,set Map
        //List arraylist linked list
        //arraylist same as array  but we dont need to init the size of the list
        //dynamically increases the size of the list
        //creating an array list

        list = new ArrayList<Email>();

        Email email = new Email("Nagendra", "Request for the monthly subscription of blog in computer science");
        Email email1 = new Email("QNet", "Request for the monthly subscription of blog in computer science");
        list.add(email);
        list.add(email1);
        adapter = new MyAdapter(list, MainActivity.this);

        recyclerView.setAdapter(adapter);
    }

    public void loadMore(View view) {


        //add  add("value") get(index) to get  , remove remove("Value")and remove(index)


        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(Email email) {


        Intent intent = new Intent(MainActivity.this, EmailBodyActivity.class);
        intent.putExtra("email_obj", (Serializable) email);
        startActivity(intent);

    }
}
