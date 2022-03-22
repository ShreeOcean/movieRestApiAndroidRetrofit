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
import com.movierestapicall.adapter.TrendingTvRecyclerAdapter;
import com.movierestapicall.databinding.FragmentTrendingTVBinding;
import com.movierestapicall.interfaces.ApiName;
import com.movierestapicall.response.TrendingResponse;
import com.movierestapicall.response.TrendingTVResponse;
import com.movierestapicall.utility.Utility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TrendingTVFrag extends Fragment {

    Context context;
    ProgressDialog progressDialog;
    TrendingTvRecyclerAdapter tvRecyclerAdapter;
    FragmentTrendingTVBinding tvBinding;
    TrendingTVResponse tvResponse;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        tvBinding = FragmentTrendingTVBinding.inflate(inflater, container, false);

//        ApiName apiName = RetrofitApi.getInstance(ApiName.class);

        tvBinding.textBtnTrendinaDay.setOnClickListener(view -> {
            showProgressDialog();
            callTrendingTVDay();
        });
        tvBinding.textBtnTrendinaWeek.setOnClickListener(view1 -> {
            showProgressDialog();
            callTrendingTVWeek();
        });

        return tvBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showProgressDialog();
        tvBinding.recyclerViewOfFragTrendTV.setLayoutManager(new LinearLayoutManager(getActivity()));
        tvBinding.recyclerViewOfFragTrendTV.setVisibility(View.VISIBLE);

        callTrendingTVDay();
    }
    private void showProgressDialog(){
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    private void callTrendingTVDay(){
        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<TrendingTVResponse> call = apiName.getTrendingTvOfDay(Utility.KEY);
        call.enqueue(new Callback<TrendingTVResponse>() {
            @Override
            public void onResponse(Call<TrendingTVResponse> call, Response<TrendingTVResponse> response) {
                if(response.isSuccessful() && response.code() == 200){
                    tvResponse = response.body();
                    progressDialog.dismiss();
                    tvRecyclerAdapter = new TrendingTvRecyclerAdapter(context, tvResponse.getTrendingTVResult());
                    tvBinding.recyclerViewOfFragTrendTV.setAdapter(tvRecyclerAdapter);
                    tvRecyclerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<TrendingTVResponse> call, Throwable t) {
                progressDialog.hide();
                Utility.showLongToast(context, t.getMessage());
            }
        });
    }

    private void callTrendingTVWeek(){
        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<TrendingTVResponse> callWeekly = apiName.getTrendingTvOfWeek(Utility.KEY);
        callWeekly.enqueue(new Callback<TrendingTVResponse>() {
            @Override
            public void onResponse(Call<TrendingTVResponse> call, Response<TrendingTVResponse> response) {
                if(response.isSuccessful() && response.code() == 200){
                    tvResponse = response.body();
                    progressDialog.dismiss();
                    tvRecyclerAdapter = new TrendingTvRecyclerAdapter(context, tvResponse.getTrendingTVResult());
                    tvBinding.recyclerViewOfFragTrendTV.setAdapter(tvRecyclerAdapter);
                    tvRecyclerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<TrendingTVResponse> call, Throwable t) {
                progressDialog.hide();
                Utility.showLongToast(context, t.getMessage());
            }
        });
    }
}