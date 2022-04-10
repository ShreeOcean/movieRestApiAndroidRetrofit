package com.movierestapicall.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movierestapicall.RetrofitApi;
import com.movierestapicall.adapter.TrendingPersonRecyclerAdapter;
import com.movierestapicall.databinding.FragmentTrendingPersonBinding;
import com.movierestapicall.interfaces.ApiName;
import com.movierestapicall.response.PopularPersonResponse;
import com.movierestapicall.response.TrendingPopularPersonResponse;
import com.movierestapicall.response.pojo.PopularPersonResultsPOJO;
import com.movierestapicall.response.pojo.TrendingPopPerson;
import com.movierestapicall.utility.Utility;

import android.app.ProgressDialog;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TrendingPersonFrag extends Fragment {

    Context context;
    FragmentTrendingPersonBinding personBinding;
    List<PopularPersonResultsPOJO> pPersonResponse = new ArrayList<>();
    TrendingPersonRecyclerAdapter personRecyclerAdapter;
    ProgressDialog progressDialog;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        personBinding = FragmentTrendingPersonBinding.inflate(inflater,container,false);
        personBinding.recyclerViewOfFragTrendPerson.setVisibility(View.VISIBLE);
        personBinding.recyclerViewOfFragTrendPerson.setLayoutManager(new LinearLayoutManager(getActivity()));

        personBinding.textBtnTrendinaDay.setOnClickListener(view -> {

            showProgressDialog();
            callTrendingPersonOfADay();

        });

        personBinding.textBtnTrendinaWeek.setOnClickListener(view -> {

            showProgressDialog();
            callTrendingPersonOfWeek();

        });

        return personBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showProgressDialog();
        personBinding.recyclerViewOfFragTrendPerson.setVisibility(View.VISIBLE);
        personBinding.recyclerViewOfFragTrendPerson.setLayoutManager(new LinearLayoutManager(getActivity()));
        callTrendingPersonOfADay();

    }

    private void showProgressDialog(){
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    private void callTrendingPersonOfADay(){

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<PopularPersonResponse> call = apiName.getTrendingPersonOfDay(Utility.KEY);
        call.enqueue(new Callback<PopularPersonResponse>() {
            @Override
            public void onResponse(Call<PopularPersonResponse> call, Response<PopularPersonResponse> response) {
                pPersonResponse = response.body().getPopularPersonResult();
                System.out.println(pPersonResponse);
                progressDialog.dismiss();
                personRecyclerAdapter = new TrendingPersonRecyclerAdapter(getContext(), pPersonResponse);
                personBinding.recyclerViewOfFragTrendPerson.setAdapter(personRecyclerAdapter);
                personRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PopularPersonResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callTrendingPersonOfWeek() {
        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<PopularPersonResponse> call = apiName.getTrendingPersonOfWeek(Utility.KEY);
        call.enqueue(new Callback<PopularPersonResponse>() {
            @Override
            public void onResponse(Call<PopularPersonResponse> call, Response<PopularPersonResponse> response) {
                pPersonResponse = response.body().getPopularPersonResult();
                progressDialog.dismiss();
                personRecyclerAdapter = new TrendingPersonRecyclerAdapter(getContext(), pPersonResponse);
                personBinding.recyclerViewOfFragTrendPerson.setAdapter(personRecyclerAdapter);
                personRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PopularPersonResponse> call, Throwable t) {
                    progressDialog.dismiss();
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}