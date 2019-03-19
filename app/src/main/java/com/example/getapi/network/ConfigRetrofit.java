package com.example.getapi.network;

import com.example.getapi.network.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {

    public static String url = "https://www.thesportsdb.com/api/v1/json/1/";

    public static Retrofit setInit() {
        return new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance() {
        return setInit().create(ApiService.class);

    }

}
