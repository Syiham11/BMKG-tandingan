package com.abdymalikmulky.bmkgtandingan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.abdymalikmulky.bmkgtandingan.weather.WeatherModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements CuacaListener{

    CuacaAdapter cuacaAdapter;
    ArrayList<Cuaca> listCuaca;

    RecyclerView rvListWeather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvListWeather = (RecyclerView) findViewById(R.id.main_list_weather);
        rvListWeather.setHasFixedSize(true);


        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvListWeather.setLayoutManager(llm);


        listCuaca = mockDataCuaca();
        cuacaAdapter = new CuacaAdapter(listCuaca, this);


        rvListWeather.setAdapter(cuacaAdapter);

        callApi();
    }


    @Override
    public void onItemClick(Cuaca cuaca) {
        Intent detailIntent = new Intent(getApplicationContext(), DetailActivity.class);

        //TODO:: Bisa pake parceler https://github.com/johncarl81/parceler
        detailIntent.putExtra("type", cuaca.getType());
        detailIntent.putExtra("day", cuaca.getDay());
        detailIntent.putExtra("degree", cuaca.getDegree());
        detailIntent.putExtra("degree2", cuaca.getDegree2());
        detailIntent.putExtra("humidity", cuaca.getHumidity());
        detailIntent.putExtra("pressure", cuaca.getPressure());
        detailIntent.putExtra("wind", cuaca.getWind());

        startActivity(detailIntent);
    }

    private ArrayList<Cuaca> mockDataCuaca() {
        ArrayList<Cuaca> listCuaca = new ArrayList<>();
        Cuaca cuaca;

        for (int i=0; i < 100; i++){
            cuaca = new Cuaca("Hujan "+i, "Senin "+i, i*10, i*3, i*30, i*333, i*4);
            listCuaca.add(cuaca);
        }
        return listCuaca;
    }


    private void callApi(){
        ApiService service = ApiHelper.client().create(ApiService.class);
        Call<WeatherModel> call = service.getCuacaDaily("Bandung", "json", "metric", "7", "352d697da89a30abe1f993dd58ad2e6b");
        call.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                Log.d("DataApi-Cuaca", response.body().toString());
//                Log.d("DataApi-Cuaca", response.body().getList().get(0).getMain());
//                Log.d("DataApi-Cuaca-desc", response.body().getList().get(0).getDescription());
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {

            }
        });
    }

}
