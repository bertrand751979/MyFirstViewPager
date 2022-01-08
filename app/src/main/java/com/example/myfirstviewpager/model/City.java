package com.example.myfirstviewpager.model;

import java.io.Serializable;

public class City implements Serializable {
    private String cityName;
    private String cityCountry;

    public City(String cityName, String cityCountry) {
        this.cityName = cityName;
        this.cityCountry = cityCountry;
    }

    public City(){}

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCountry() {
        return cityCountry;
    }

    public void setCityCountry(String cityCountry) {
        this.cityCountry = cityCountry;
    }
}
