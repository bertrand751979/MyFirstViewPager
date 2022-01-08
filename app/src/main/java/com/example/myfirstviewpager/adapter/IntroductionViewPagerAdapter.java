package com.example.myfirstviewpager.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myfirstviewpager.fragment.DisplayFragment;
import com.example.myfirstviewpager.fragment.SelectionFragment;

public class IntroductionViewPagerAdapter extends FragmentStateAdapter {

    public IntroductionViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if(position==0){
            Fragment fragment = new DisplayFragment();
            return fragment;
        }else{
            Fragment fragment = new SelectionFragment();
            return fragment;

        }





    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
