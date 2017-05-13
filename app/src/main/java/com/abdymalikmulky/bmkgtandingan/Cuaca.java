package com.abdymalikmulky.bmkgtandingan;

/**
 * Bismillahirrahmanirrahim
 * Created by abdymalikmulky on 5/6/17.
 */

public class Cuaca {
    String type;
    String day;
    int degree;
    int degree2;
    //variable tambahan
    int humidity;
    int pressure;
    double wind;

    public Cuaca(String type, String day, int degree, int degree2, int humidity, int pressure, double wind) {
        this.type = type;
        this.day = day;
        this.degree = degree;
        this.degree2 = degree2;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wind = wind;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getDegree2() {
        return degree2;
    }

    public void setDegree2(int degree2) {
        this.degree2 = degree2;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "Cuaca{" +
                "type='" + type + '\'' +
                ", day='" + day + '\'' +
                ", degree=" + degree +
                ", degree2=" + degree2 +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", wind=" + wind +
                '}';
    }
}
