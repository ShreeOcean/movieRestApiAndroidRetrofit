package com.movierestapicall.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movierestapicall.R;
import com.movierestapicall.response.pojo.PopularPersonResultsPOJO;


public class FragPopPersonDetails extends Fragment {

    public FragPopPersonDetails(int position) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pop_person_details, container, false);
    }
}