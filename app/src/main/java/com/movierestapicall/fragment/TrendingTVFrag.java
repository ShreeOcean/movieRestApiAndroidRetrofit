package com.movierestapicall.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movierestapicall.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrendingTVFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrendingTVFrag extends Fragment {

    Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending_t_v, container, false);
    }
}