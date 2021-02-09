package com.example.mvcdemo.controller;

import android.util.Log;

import com.example.mvcdemo.Model.Country;
import com.example.mvcdemo.Model.MainRepo;
import com.example.mvcdemo.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainController {
    private final MainActivity view;
    private static final String TAG = "MainController";
    //In Controller we write the business logic

    private MainRepo repo;

    public MainController(MainActivity mainActivity) {
        this.view=mainActivity;
         repo = new MainRepo(this);
        fetchUsers();
    }

    public void fetchUsers() {
         repo.getUserList( );
        //here we send the data collected from the model(through MainRepo) to activity
     }

    public void sendNetWrokResults(List<Country> body) {
        this.view.renderUsers(body);
    }
}
