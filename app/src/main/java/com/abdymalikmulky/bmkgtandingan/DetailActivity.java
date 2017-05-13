package com.abdymalikmulky.bmkgtandingan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    Cuaca cuaca;
    String type, day;
    int degree, degree2, humidity, pressure;
    double wind;



    TextView detailToday, detailTodayWeathText, detailTodayDegree, detailHumidity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        day = intent.getStringExtra("day");
        degree = intent.getIntExtra("degree", 0);
        degree2 = intent.getIntExtra("degree2", 0);
        humidity = intent.getIntExtra("humidity", 0);
        pressure = intent.getIntExtra("pressure", 0);
        wind = intent.getDoubleExtra("wind", 0);


        //TODO:: Bisa pake butterknife https://github.com/JakeWharton/butterknife
        detailToday = (TextView) findViewById(R.id.detail_today);
        detailTodayWeathText = (TextView) findViewById(R.id.detail_today_weath_text);
        detailTodayDegree = (TextView) findViewById(R.id.detailtoday_degree);
        detailHumidity = (TextView) findViewById(R.id.detail_humidity);

        detailToday.setText(day);
        detailTodayWeathText.setText(type);
        detailTodayDegree.setText(String.valueOf(degree));
        detailHumidity.setText(String.valueOf(humidity));
    }
}
