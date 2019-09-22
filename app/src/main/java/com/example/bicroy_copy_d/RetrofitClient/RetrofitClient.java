package com.example.bicroy_copy_d.RetrofitClient;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit myClient=null;
    private RetrofitClient(){
    }

    public static Retrofit getInstance(){
        if (myClient == null){
            myClient=new Retrofit.Builder()
                        .baseUrl("https://us-central1-olxc-4ae72.cloudfunctions.net/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
        return myClient;
    }
}
