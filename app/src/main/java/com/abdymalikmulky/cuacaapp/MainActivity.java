package com.abdymalikmulky.cuacaapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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
        cuacaAdapter = new CuacaAdapter(listCuaca);


        rvListWeather.setAdapter(cuacaAdapter);
    }

    private ArrayList<Cuaca> mockDataCuaca() {
        ArrayList<Cuaca> listCuaca = new ArrayList<>();
        Cuaca cuaca;

        for (int i=0; i < 100; i++){
            cuaca = new Cuaca("Hujan "+i, "Senin "+i, i*10, i*3);
            listCuaca.add(cuaca);
        }
        return listCuaca;
    }
}
