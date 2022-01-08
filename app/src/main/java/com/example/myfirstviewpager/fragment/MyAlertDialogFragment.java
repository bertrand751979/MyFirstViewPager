package com.example.myfirstviewpager.fragment;


import static com.example.myfirstviewpager.fragment.DisplayFragment.KEY_LIST;
import static com.example.myfirstviewpager.fragment.DisplayFragment.KEY_SELECTED_LIST;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.example.myfirstviewpager.R;
import com.example.myfirstviewpager.SharedPreferencesManager;
import com.example.myfirstviewpager.adapter.CityAdapter;
import com.example.myfirstviewpager.model.City;
import java.util.ArrayList;

public class MyAlertDialogFragment extends DialogFragment {

    public static EditText mEditText;
    private Button done;
    private Button cancel;
    private ArrayList<City>list;
    private ArrayList<City>mySearchingList = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>(SharedPreferencesManager.getInstance(this.getContext()).getCityList(KEY_LIST));
    }

    public MyAlertDialogFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        done =view.findViewById(R.id.btnDone);
        cancel =view.findViewById(R.id.btnCancel);
        mEditText = (EditText) view.findViewById(R.id.txt_your_search);
        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(done==view){
                    searchChoice();
                    dismiss();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    public static MyAlertDialogFragment newInstance(String title) {
        MyAlertDialogFragment frag = new MyAlertDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    public void searchChoice() {
        if (MyAlertDialogFragment.mEditText.getText().toString().equals("")) {
            Toast.makeText(MyAlertDialogFragment.this.getContext(), "Erreur Saisie vide ", Toast.LENGTH_SHORT).show();
        } else {
            for (City city : list) {
                if (city.getCityCountry().toLowerCase().contains(mEditText.getText().toString().toLowerCase())) {
                    mySearchingList.add(city);
                    SharedPreferencesManager.getInstance(this.getContext()).saveSelectedList(mySearchingList,KEY_SELECTED_LIST);


                }
            }
        }
    }

}
