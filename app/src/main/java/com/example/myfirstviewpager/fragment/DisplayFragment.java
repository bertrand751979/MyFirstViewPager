package com.example.myfirstviewpager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstviewpager.SharedPreferencesManager;
import com.example.myfirstviewpager.model.City;
import com.example.myfirstviewpager.OnImageCancelActionClicked;
import com.example.myfirstviewpager.R;
import com.example.myfirstviewpager.adapter.CityAdapter;

import java.util.ArrayList;

public class DisplayFragment extends Fragment {
    public static final String ARG_OBJECT = "object";

    public static MenuItem itemSearch;
    public static MenuItem itemMenu;
    public  ArrayList<City> myListCity = new ArrayList<>();
    private RecyclerView recyclerView;
    public   CityAdapter cityAdapter;
    private EditText editCity;
    private EditText editCountry;
    private Button btnSave;
    public static String KEY_ADD_TO_LIST="keyAddToList";
    public static String KEY_LIST="KeyList";
    public static String KEY_SELECTED_LIST="keySelectedList";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        City city1 = new City("Dakar", "SENEGAL");
        City city2 = new City("Paris", "FRANCE");
        City city3 = new City("Lomé", "TOGO");
        City city4 = new City("Barcelone", "ESPAGNE");
        City city5 = new City("Rome", "ITALIE");
        City city6 = new City("Aného", "TOGO");
        myListCity.add(city1);
        myListCity.add(city2);
        myListCity.add(city3);
        myListCity.add(city4);
        myListCity.add(city5);
        myListCity.add(city6);
        SharedPreferencesManager.getInstance(this.getContext()).saveCityList(myListCity,KEY_LIST);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_display, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_display);
        editCity = view.findViewById(R.id.edit_city);
        editCountry = view.findViewById(R.id.edit_country);
        btnSave = view.findViewById(R.id.btn_save_city);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCity();
            }
        });

        setViewItem();
    }

    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        OnImageCancelActionClicked onImageCancelActionClicked = new OnImageCancelActionClicked() {
            @Override
            public void deleteItem(City city) {
                myListCity.remove(city);
                cityAdapter.setListCities(myListCity);
                cityAdapter.notifyDataSetChanged();
            }
        };
        cityAdapter = new CityAdapter(myListCity,onImageCancelActionClicked);
        recyclerView.setAdapter(cityAdapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_menu, menu);
        itemMenu=menu.findItem(R.id.menu_icon);
        itemSearch = menu.findItem(R.id.display_cities_by_country);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_icon:
                return (true);

            case R.id.display_cities_by_country:
                showAlertDialog();
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }

    private void showAlertDialog() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        MyAlertDialogFragment alertDialog = MyAlertDialogFragment.newInstance("Some title");
        alertDialog.show(fm, "fragment_alert");
    }

    private void addCity(){
        City city = new City();
        city.setCityName(editCity.getText().toString());
        city.setCityCountry(editCountry.getText().toString());
        myListCity.add(city);
        SharedPreferencesManager.getInstance(this.getContext()).saveSelectedList(myListCity,KEY_LIST);
    }

}
