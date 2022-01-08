package com.example.myfirstviewpager.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstviewpager.model.City;
import com.example.myfirstviewpager.R;
import com.example.myfirstviewpager.viewHolder.SelectionViewHolder;

import java.util.ArrayList;

public class SelectionAdapter extends RecyclerView.Adapter<SelectionViewHolder> {
    private ArrayList<City> listSelections;

    public SelectionAdapter(ArrayList<City> listSelections) {
        this.listSelections = listSelections;
    }

    public void setListSelections(ArrayList<City> listSelections) {
        this.listSelections = listSelections;
    }

    @NonNull
    @Override
    public SelectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_selection,parent,false);
        return new SelectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectionViewHolder holder, int position) {
        holder.bind(listSelections.get(position));
    }

    @Override
    public int getItemCount() {
        return listSelections.size();
    }
}
