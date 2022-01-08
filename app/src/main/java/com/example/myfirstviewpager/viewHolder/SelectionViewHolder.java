package com.example.myfirstviewpager.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstviewpager.model.City;
import com.example.myfirstviewpager.R;

public class SelectionViewHolder extends RecyclerView.ViewHolder {
    private TextView vhSelectionCityName;
    private TextView vhSelectionCityCountry;

    public SelectionViewHolder(@NonNull View view) {
        super(view);
        vhSelectionCityName = view.findViewById(R.id.raw_selection_city);
        vhSelectionCityCountry = view.findViewById(R.id.raw_selection_city_country);
    }

    public TextView getVhSelectionCityName() {
        return vhSelectionCityName;
    }

    public void setVhSelectionCityName(TextView vhSelectionCityName) {
        this.vhSelectionCityName = vhSelectionCityName;
    }

    public TextView getVhSelectionCityCountry() {
        return vhSelectionCityCountry;
    }

    public void setVhSelectionCityCountry(TextView vhSelectionCityCountry) {
        this.vhSelectionCityCountry = vhSelectionCityCountry;
    }

    public void bind(City city){
        vhSelectionCityName.setText(city.getCityName());
        vhSelectionCityCountry.setText(city.getCityCountry());
    }

}
