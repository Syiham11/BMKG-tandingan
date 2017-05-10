package com.abdymalikmulky.cuacaapp;

/**
 * Bismillahirrahmanirrahim
 * Created by abdymalikmulky on 5/6/17.
 */

public class Cuaca {
    String type;
    String day;
    int degree;
    int degree2;

    public Cuaca(String type, String day, int degree, int degree2) {
        this.type = type;
        this.day = day;
        this.degree = degree;
        this.degree2 = degree2;
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


}
