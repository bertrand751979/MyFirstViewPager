package com.example.myfirstviewpager;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.myfirstviewpager.model.City;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SharedPreferencesManager {

    public static final String MY_PREF = "AppPreferences";
    private static SharedPreferencesManager INSTANCE = null;
    private SharedPreferences sharedPreferences;

    //pour transformer une classe en singleton mettre prive
    private SharedPreferencesManager(Context context) {
        this.sharedPreferences = context.getSharedPreferences(MY_PREF, 0);
    }

    //ca economise du code c'est un objet partage le singleton est ce que mon objet existe deja cas contraire on la cree
    public static synchronized SharedPreferencesManager getInstance(Context context) {
        if(INSTANCE == null){
            INSTANCE = new SharedPreferencesManager(context);
        }
        return INSTANCE;
    }

    public void save(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public String get(String key) {
        return this.sharedPreferences.getString(key, null);
    }

    public void remove(String key) {
        sharedPreferences.edit().remove(key).apply();
    }

    public void clear() {
        sharedPreferences.edit().clear().apply();
    }

    public void saveCityList(List<City> books, String listKey) {
        Gson gson = new Gson();
        //gson.tojson qui transforme la liste en chaine de caractere
        String booksAsString = gson.toJson(books);
        save(listKey,booksAsString);
    }

    public List<City> getCityList(String listKey){
        List<City> booksList = new ArrayList<>();
        Gson gson = new Gson();
        City[] books = gson.fromJson(get(listKey), City[].class);
        if (books != null){
            booksList = Arrays.asList(gson.fromJson(get(listKey), City[].class));
        }
        return  booksList;
    }

    public void addCityToList(City city,String listKey ){
        ArrayList<City> books = new ArrayList<>(getCityList(listKey));
        remove(listKey);
        books.add(city);
        saveCityList(books,listKey);
    }


    public void saveSelectedList(List<City> books, String listKey) {
        Gson gson = new Gson();
        //gson.tojson qui transforme la liste en chaine de caractere
        String booksAsString = gson.toJson(books);
        save(listKey,booksAsString);
    }

    public List<City> getSelectedList(String listKey){
        List<City> booksList = new ArrayList<>();
        Gson gson = new Gson();
        City[] books = gson.fromJson(get(listKey), City[].class);
        if (books != null){
            booksList = Arrays.asList(gson.fromJson(get(listKey), City[].class));
        }
        return  booksList;
    }















}
