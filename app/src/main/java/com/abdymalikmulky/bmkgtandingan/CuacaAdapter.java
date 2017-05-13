package com.abdymalikmulky.bmkgtandingan;

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

    CuacaListener cuacaListener;

    ArrayList<Cuaca> listCuaca;

    public CuacaAdapter(ArrayList<Cuaca> listCuaca, CuacaListener listener) {
        this.listCuaca = listCuaca;
        this.cuacaListener = listener;
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
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Cuaca cuaca = listCuaca.get(position);

        holder.tvWeatherDay.setText(cuaca.getDay());
        holder.tvWeatherDesc.setText(cuaca.getType());
        holder.tvDegree.setText(String.valueOf(cuaca.getDegree()));
        holder.tvDegree2.setText(String.valueOf(cuaca.getDegree2()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cuacaListener.onItemClick(cuaca);
            }
        });
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
