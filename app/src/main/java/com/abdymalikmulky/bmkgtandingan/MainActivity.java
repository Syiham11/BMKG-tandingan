package com.abdymalikmulky.bmkgtandingan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.abdymalikmulky.bmkgtandingan.weather.WeatherList;
import com.abdymalikmulky.bmkgtandingan.weather.WeatherModel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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


        listCuaca = new ArrayList<>();
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
        final ArrayList<Cuaca> listCuaca = new ArrayList<>();


        ApiService service = ApiHelper.client().create(ApiService.class);
        Call<WeatherModel> call = service.getCuacaDaily("Brazil", "json", "metric", "7", "352d697da89a30abe1f993dd58ad2e6b");
        call.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                //hasil dari api
                List<WeatherList> weatherLists = response.body().getList();
                for (WeatherList wList : weatherLists) {
                    Log.d("DataAPI-cuaca", wList.toString());

                    //data tanggal
                    long dateTime = wList.getDt();
                    String date = tiemstampToDate(dateTime);

                    //jenis cuaca
                    String type = wList.getWeather().get(0).getMain();

                    float degree = wList.getSpeed();
                    float degree2 = wList.getDeg();

                    int humidity = wList.getHumidity();
                    float press = wList.getPressure();
                    double wind = wList.getSpeed();


                    Cuaca cuaca = new Cuaca();
                    cuaca.setType(type);
                    cuaca.setDay(date);
                    cuaca.setDegree((int) degree);
                    cuaca.setDegree2((int) degree2);
                    cuaca.setHumidity(humidity);
                    cuaca.setPressure((int) press);
                    cuaca.setWind(wind);

                    listCuaca.add(cuaca);
                }

                cuacaAdapter.refreshData(listCuaca);

            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {

            }
        });
    }

    private String tiemstampToDate(long timestamp){
        long timestampLong = timestamp*1000;
        Date d = new Date(timestampLong);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);

        return date+"-"+month+"-"+year;
    }
}
