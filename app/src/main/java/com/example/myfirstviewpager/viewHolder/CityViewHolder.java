package com.example.myfirstviewpager.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstviewpager.model.City;
import com.example.myfirstviewpager.OnImageCancelActionClicked;
import com.example.myfirstviewpager.R;
import com.google.android.material.card.MaterialCardView;

public class CityViewHolder extends RecyclerView.ViewHolder {
    private TextView vhDisplayCityName;
    private TextView vhDisplayCityCountry;
    private ImageView vhDisplayCancelButton;
    private TextView vhDisplayStatut;
    private MaterialCardView materialCardView;


    public CityViewHolder(@NonNull View view) {
        super(view);
        vhDisplayCityName = view.findViewById(R.id.raw_city_name);
        vhDisplayCityCountry = view.findViewById(R.id.raw_city_country_name);
        vhDisplayCancelButton = view.findViewById(R.id.raw_cancel);
        vhDisplayStatut = view.findViewById(R.id.raw_statut);
        materialCardView = view.findViewById(R.id.raw_materialCard);
    }

    public TextView getVhDisplayCityName() {
        return vhDisplayCityName;
    }

    public void setVhDisplayCityName(TextView vhDisplayCityName) {
        this.vhDisplayCityName = vhDisplayCityName;
    }

    public TextView getVhDisplayCityCountry() {
        return vhDisplayCityCountry;
    }

    public void setVhDisplayCityCountry(TextView vhDisplayCityCountry) {
        this.vhDisplayCityCountry = vhDisplayCityCountry;
    }

    public ImageView getVhDisplayCancelButton() {
        return vhDisplayCancelButton;
    }

    public void setVhDisplayCancelButton(ImageView vhDisplayCancelButton) {
        this.vhDisplayCancelButton = vhDisplayCancelButton;
    }

    public TextView getVhDisplayStatut() {
        return vhDisplayStatut;
    }

    public void setVhDisplayStatut(TextView vhDisplayStatut) {
        this.vhDisplayStatut = vhDisplayStatut;
    }

    public MaterialCardView getMaterialCardView() {
        return materialCardView;
    }

    public void setMaterialCardView(MaterialCardView materialCardView) {
        this.materialCardView = materialCardView;
    }

    public void bind(City city, OnImageCancelActionClicked onImageCancelActionClicked){
        vhDisplayCityName.setText(city.getCityName());
        vhDisplayCityCountry.setText(city.getCityCountry());
        vhDisplayCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onImageCancelActionClicked.deleteItem(city);
            }
        });
        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(materialCardView==view){
                    vhDisplayStatut.setText("Cliqué");
                }
            }
        });




    }
}
