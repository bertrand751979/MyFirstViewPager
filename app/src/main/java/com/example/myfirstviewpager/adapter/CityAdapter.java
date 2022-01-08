package com.example.myfirstviewpager.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstviewpager.model.City;
import com.example.myfirstviewpager.viewHolder.CityViewHolder;
import com.example.myfirstviewpager.OnImageCancelActionClicked;
import com.example.myfirstviewpager.R;

import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityViewHolder>{
    private ArrayList<City>listCities;
    private OnImageCancelActionClicked onImageCancelActionClicked;

    public CityAdapter(ArrayList<City> listCities, OnImageCancelActionClicked onImageCancelActionClicked) {
        this.listCities = listCities;
        this.onImageCancelActionClicked = onImageCancelActionClicked;
    }

    public void setListCities(ArrayList<City> listCities) {
        this.listCities = listCities;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_display,parent,false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        holder.bind(listCities.get(position),onImageCancelActionClicked);
    }

    @Override
    public int getItemCount() {
        return listCities.size();
    }


}
