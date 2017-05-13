package com.abdymalikmulky.bmkgtandingan;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Bismillahirrahmanirrahim
 * Created by abdymalikmulky on 5/13/17.
 */

public class ApiHelper {

    private static String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/";
    static Retrofit retrofit = null;

    public static Retrofit client() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();



        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }


}
