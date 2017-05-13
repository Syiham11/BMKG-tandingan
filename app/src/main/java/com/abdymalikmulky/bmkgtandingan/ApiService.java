package com.abdymalikmulky.bmkgtandingan;

import com.abdymalikmulky.bmkgtandingan.weather.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Bismillahirrahmanirrahim
 * Created by abdymalikmulky on 5/13/17.
 */

public interface ApiService {

    @GET("daily")
    Call<WeatherModel> getCuacaDaily(@Query("q") String q, @Query("mode") String mode, @Query("units") String unit,
                                     @Query("cnt") String count, @Query("appid") String appid);

}
