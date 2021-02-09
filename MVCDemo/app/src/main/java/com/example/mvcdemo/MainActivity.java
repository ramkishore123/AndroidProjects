package com.example.mvcdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mvcdemo.Model.Country;
import com.example.mvcdemo.Model.MainRepo;
import com.example.mvcdemo.Model.User;
import com.example.mvcdemo.R;
import com.example.mvcdemo.adapter.MyAdapter;
import com.example.mvcdemo.controller.MainController;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    //This is a view class and we write only view related logic in view classes

    private RecyclerView recyclerView;
    private TextView tvUser;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvUser = findViewById(R.id.tv_user);
        MainController controller=new MainController(MainActivity.this);
    }

    public void renderUsers(List<Country> list) {
        //TODO show to list in recycler view
        recyclerView=findViewById(R.id.rv_item);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);
        adapter= new MyAdapter(MainActivity.this, list);
        recyclerView.setAdapter(adapter);

//        for (Country item : list) {
//            tvUser.append(item.countryName+ "\n");
//        }
    }
}
