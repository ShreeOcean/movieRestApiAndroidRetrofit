package com.movierestapicall.fragment;

import android.app.ProgressDialog;
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

import com.movierestapicall.PopularMovieActivity;
import com.movierestapicall.R;
import com.movierestapicall.RetrofitApi;
import com.movierestapicall.TrendingActivity;
import com.movierestapicall.adapter.TrendingAllRecyclerAdapter;
import com.movierestapicall.databinding.FragmentTrendingAllBinding;
import com.movierestapicall.interfaces.ApiName;
import com.movierestapicall.response.TrendingResponse;
import com.movierestapicall.response.pojo.TrendingResultsPOJO;
import com.movierestapicall.utility.Utility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendingAllFrag extends Fragment {

    private TrendingAllRecyclerAdapter recyclerAdapter;
    ProgressDialog progressDialog;
    Context context;
    TrendingResponse trendingResponse;
    FragmentTrendingAllBinding trendingAllBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        trendingAllBinding = FragmentTrendingAllBinding.inflate(inflater, container, false);
        //return inflater.inflate(R.layout.fragment_trending_all, container, false);
        return trendingAllBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        trendingAllBinding.recyclerViewFromTrendingAll.setVisibility(View.VISIBLE);
        trendingAllBinding.recyclerViewFromTrendingAll.setLayoutManager(new LinearLayoutManager(getActivity()));
        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<TrendingResponse> call = apiName.getTrendingAllOfDay(Utility.KEY);
        call.enqueue(new Callback<TrendingResponse>() {
            @Override
            public void onResponse(Call<TrendingResponse> call, Response<TrendingResponse> response) {
                if(response.isSuccessful() && response.code() == 200){
                    trendingResponse = (TrendingResponse) response.body();
                    for (TrendingResultsPOJO trendingResultsPOJO : trendingResponse.getTrendingResult()) {
                        progressDialog.dismiss();
                        recyclerAdapter = new TrendingAllRecyclerAdapter(context, trendingResponse.getTrendingResult());
                        trendingAllBinding.recyclerViewFromTrendingAll.setAdapter(recyclerAdapter);
                        recyclerAdapter.notifyDataSetChanged();

                        Log.d("Trending All Frag", "onResponse: " + trendingResultsPOJO.getOriginalTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<TrendingResponse> call, Throwable t) {
                progressDialog.hide();
                Utility.showLongToast(context, t.getMessage());
            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = getActivity();
    }
}