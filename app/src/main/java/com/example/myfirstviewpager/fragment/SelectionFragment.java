package com.example.myfirstviewpager.fragment;

import static com.example.myfirstviewpager.fragment.DisplayFragment.KEY_LIST;
import static com.example.myfirstviewpager.fragment.DisplayFragment.KEY_SELECTED_LIST;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myfirstviewpager.R;
import com.example.myfirstviewpager.SharedPreferencesManager;
import com.example.myfirstviewpager.adapter.SelectionAdapter;
import com.example.myfirstviewpager.model.City;

import java.util.ArrayList;

public class SelectionFragment extends Fragment {
    private RecyclerView recyclerView;
    private SelectionAdapter selectionAdapter;
    private ArrayList<City>listSelected = new ArrayList<>();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        listSelected = new ArrayList<>(SharedPreferencesManager.getInstance(this.getContext()).getSelectedList(KEY_SELECTED_LIST));
        selectionAdapter.setListSelections(listSelected);
        selectionAdapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_selection, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycler_view_selection);
        setViewItem();
    }

    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        selectionAdapter = new SelectionAdapter(listSelected);
        recyclerView.setAdapter(selectionAdapter);

    }
}
