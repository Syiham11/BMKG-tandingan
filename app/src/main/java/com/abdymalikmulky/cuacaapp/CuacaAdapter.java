package com.abdymalikmulky.cuacaapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Bismillahirrahmanirrahim
 * Created by abdymalikmulky on 5/6/17.
 */

public class CuacaAdapter extends RecyclerView.Adapter<CuacaAdapter.ViewHolder> {

    ArrayList<Cuaca> listCuaca;

    public CuacaAdapter(ArrayList<Cuaca> listCuaca) {
        this.listCuaca = listCuaca;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivWeatherIcon;
        TextView tvWeatherDay, tvWeatherDesc, tvDegree, tvDegree2;

        public ViewHolder(View v) {
            super(v);
            ivWeatherIcon = (ImageView) v.findViewById(R.id.list_item_weather_icon);
            tvWeatherDay = (TextView) v.findViewById(R.id.list_item_weather_day);
            tvWeatherDesc = (TextView) v.findViewById(R.id.list_item_weather_desc);
            tvDegree = (TextView) v.findViewById(R.id.list_item_degree);
            tvDegree2 = (TextView) v.findViewById(R.id.list_item_degree2);

        }
    }

    @Override
    public CuacaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_weather, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvWeatherDay.setText(listCuaca.get(position).getDay());
        holder.tvWeatherDesc.setText(listCuaca.get(position).getType());
        holder.tvDegree.setText(String.valueOf(listCuaca.get(position).getDegree()));
        holder.tvDegree2.setText(String.valueOf(listCuaca.get(position).getDegree2()));
    }

    @Override
    public int getItemCount() {
        return listCuaca.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
