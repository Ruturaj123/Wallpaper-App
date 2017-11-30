package com.example.ruturaj.wallpaperapp.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ruturaj on 26/11/17.
 */

public class Client {
    public static final String BASE_URL ="https://pixabay.com/";
    public static Retrofit instance = null;

    public static Retrofit getClient(){
        if(instance == null)
            instance = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();
        return instance;
    }
}
