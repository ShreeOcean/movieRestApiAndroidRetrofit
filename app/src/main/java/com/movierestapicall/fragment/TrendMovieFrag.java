package com.movierestapicall.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movierestapicall.R;
import com.movierestapicall.RetrofitApi;
import com.movierestapicall.adapter.TrendingMovieListAdapter;
import com.movierestapicall.databinding.FragmentTrendMovieBinding;
import com.movierestapicall.interfaces.ApiName;
import com.movierestapicall.response.TrendingMovieResponse;
import com.movierestapicall.utility.Utility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendMovieFrag extends Fragment {

    Context context;
    ProgressDialog progressDialog;
    FragmentTrendMovieBinding binding;
    TrendingMovieListAdapter listAdapter;
    TrendingMovieResponse movieResponse;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentTrendMovieBinding.inflate(inflater, container, false);

        binding.textBtnTrendinaDay.setOnClickListener(view -> {
            showProgressDialog();
            callTrendingMovieInADay();
        });
        binding.textBtnTrendinaWeek.setOnClickListener(view -> {
            showProgressDialog();
            callTrendingMovieInAWeek();
        });

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showProgressDialog();
        binding.recyclerViewOfFragTrendMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerViewOfFragTrendMovie.setVisibility(View.VISIBLE);

        callTrendingMovieInADay();
    }

    private void showProgressDialog(){
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    private void callTrendingMovieInAWeek() {

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<TrendingMovieResponse> call = apiName.getTrendingMovieOfWeek(Utility.KEY);
        call.enqueue(new Callback<TrendingMovieResponse>() {
            @Override
            public void onResponse(Call<TrendingMovieResponse> call, Response<TrendingMovieResponse> response) {
                if (response.isSuccessful() && response.code() == 200){
                    progressDialog.dismiss();
                    movieResponse = response.body();
                    listAdapter = new TrendingMovieListAdapter(context, movieResponse.getResults());
                    binding.recyclerViewOfFragTrendMovie.setAdapter(listAdapter);
                    listAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<TrendingMovieResponse> call, Throwable t) {
                progressDialog.dismiss();
                Utility.showLongToast(context, t.getMessage());
            }
        });
    }

    private void callTrendingMovieInADay() {

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<TrendingMovieResponse> call = apiName.getTrendingMovieOfDay(Utility.KEY);
        call.enqueue(new Callback<TrendingMovieResponse>() {
            @Override
            public void onResponse(Call<TrendingMovieResponse> call, Response<TrendingMovieResponse> response) {
                if (response.isSuccessful() && response.code() == 200){
                    progressDialog.dismiss();
                    movieResponse = response.body();
                    listAdapter = new TrendingMovieListAdapter(context, movieResponse.getResults());
                    binding.recyclerViewOfFragTrendMovie.setAdapter(listAdapter);
                    listAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<TrendingMovieResponse> call, Throwable t) {
                progressDialog.dismiss();
                Utility.showLongToast(context, t.getMessage());
            }
        });
    }
}