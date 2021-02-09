package com.example.mvcdemo.Model;

import com.example.mvcdemo.controller.MainController;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainRepo {

    private final MainController controller;
    private Response<List<Country>> execute;

    public MainRepo(MainController mainController) {
        this.controller=mainController;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(CountriesApi.class);
    }

    //In repo we write data related logic like network request and Db Related code
    private List<User> list;

    public static final String BASE_URL = "https://restcountries.eu/rest/v2/";

    private CountriesApi api;

    public void getUserList() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                api.getCountries().enqueue(new Callback<List<Country>>() {
                    @Override
                    public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                        controller.sendNetWrokResults(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Country>> call, Throwable t) {

                    }
                });
            }
        }).start();
    }
}
