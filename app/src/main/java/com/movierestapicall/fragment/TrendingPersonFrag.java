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

import com.movierestapicall.R;
import com.movierestapicall.RetrofitApi;
import com.movierestapicall.adapter.TrendingPersonRecyclerAdapter;
import com.movierestapicall.databinding.FragmentTrendingPersonBinding;
import com.movierestapicall.interfaces.ApiName;
import com.movierestapicall.response.TrendingPopularPerson;
import com.movierestapicall.response.pojo.PopularPersonResultsPOJO;
import com.movierestapicall.utility.Utility;

import android.app.ProgressDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TrendingPersonFrag extends Fragment {

    Context context;
    FragmentTrendingPersonBinding personBinding;
    TrendingPopularPerson personResponse;
    TrendingPersonRecyclerAdapter personRecyclerAdapter;
    ProgressDialog progressDialog;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        personBinding = FragmentTrendingPersonBinding.inflate(inflater,container,false);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        personBinding.textBtnTrendinaDay.setOnClickListener(view -> {

            progressDialog.show();

            Call<TrendingPopularPerson> call = apiName.getTrendingPersonOfDay(Utility.KEY);
            call.enqueue(new Callback<TrendingPopularPerson>() {
                @Override
                public void onResponse(Call<TrendingPopularPerson> call, Response<TrendingPopularPerson> response) {
                    if(response.isSuccessful() && response.code() == 200){
                        personResponse = response.body();
                        for(PopularPersonResultsPOJO resultsPOJO : personResponse.getPopularMoviesResult()){
                            progressDialog.dismiss();
                            personRecyclerAdapter = new TrendingPersonRecyclerAdapter(context, personResponse.getPopularMoviesResult());
                            personBinding.recyclerViewOfFragTrendPerson.setAdapter(personRecyclerAdapter);
                            personRecyclerAdapter.notifyDataSetChanged();

                            Log.d("TrendingPersonFrag", "onResponse: trending person of day" + resultsPOJO.getName());
                        }
                    }
                }

                @Override
                public void onFailure(Call<TrendingPopularPerson> call, Throwable t) {
                    progressDialog.hide();
                    Utility.showLongToast(context, t.getMessage());
                }
            });

        });

        personBinding.textBtnTrendinaWeek.setOnClickListener(view -> {

            progressDialog.show();

            Call<TrendingPopularPerson> call = apiName.getTrendingPersonOfWeek(Utility.KEY);
            call.enqueue(new Callback<TrendingPopularPerson>() {
                @Override
                public void onResponse(Call<TrendingPopularPerson> call, Response<TrendingPopularPerson> response) {
                    if(response.isSuccessful() && response.code() == 200){
                        personResponse = response.body();
                        for(PopularPersonResultsPOJO resultsPOJO : personResponse.getPopularMoviesResult()){
                            progressDialog.dismiss();
                            personRecyclerAdapter = new TrendingPersonRecyclerAdapter(context, personResponse.getPopularMoviesResult());
                            personBinding.recyclerViewOfFragTrendPerson.setAdapter(personRecyclerAdapter);
                            personRecyclerAdapter.notifyDataSetChanged();

                            Log.d("TrendingPersonFrag", "onResponse: trending person of day" + resultsPOJO.getName());
                        }
                    }
                }

                @Override
                public void onFailure(Call<TrendingPopularPerson> call, Throwable t) {
                    progressDialog.hide();
                    Utility.showLongToast(context, t.getMessage());
                }
            });
        });

        return personBinding.getRoot();
        //return inflater.inflate(R.layout.fragment_trending_person, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        personBinding.recyclerViewOfFragTrendPerson.setVisibility(View.VISIBLE);
        personBinding.recyclerViewOfFragTrendPerson.setLayoutManager(new LinearLayoutManager(getActivity()));

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<TrendingPopularPerson> call = apiName.getTrendingPersonOfDay(Utility.KEY);
        call.enqueue(new Callback<TrendingPopularPerson>() {
            @Override
            public void onResponse(Call<TrendingPopularPerson> call, Response<TrendingPopularPerson> response) {
                if(response.isSuccessful() && response.code() == 200){
                    personResponse = response.body();
                    for(PopularPersonResultsPOJO resultsPOJO : personResponse.getPopularMoviesResult()){
                        progressDialog.dismiss();
                        personRecyclerAdapter = new TrendingPersonRecyclerAdapter(context, personResponse.getPopularMoviesResult());
                        personBinding.recyclerViewOfFragTrendPerson.setAdapter(personRecyclerAdapter);
                        personRecyclerAdapter.notifyDataSetChanged();

                        Log.d("TrendingPersonFrag", "onResponse: trending person of day" + resultsPOJO.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<TrendingPopularPerson> call, Throwable t) {
                progressDialog.hide();
                Utility.showLongToast(context, t.getMessage());
            }
        });
    }
}