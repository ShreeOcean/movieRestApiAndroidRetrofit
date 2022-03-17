package com.movierestapicall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.movierestapicall.databinding.ActivityTrendingBinding;
import com.movierestapicall.fragment.TrendMovieFrag;
import com.movierestapicall.fragment.TrendingAllFrag;
import com.movierestapicall.fragment.TrendingPersonFrag;
import com.movierestapicall.fragment.TrendingTVFrag;
import com.movierestapicall.interfaces.ApiName;
import com.movierestapicall.response.TrendingResponse;
import com.movierestapicall.utility.Utility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendingActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityTrendingBinding trendingBinding;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        trendingBinding = ActivityTrendingBinding.inflate(getLayoutInflater());
        setContentView(trendingBinding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        //progressDialog.show();

        trendingBinding.textBtnTrendingAll.setOnClickListener(this);
        trendingBinding.textBtnTrendingTv.setOnClickListener(this);
        trendingBinding.textBtnTrendingMovie.setOnClickListener(this);
        trendingBinding.textBtnPerson.setOnClickListener(this);
        replaceTrendActivityToTrendindAllFrag(new TrendingAllFrag());
//        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
//        Call<TrendingResponse> call = apiName.getTrendingAllOfDay(Utility.KEY);
//        call.enqueue(new Callback<TrendingResponse>() {
//            @Override
//            public void onResponse(Call<TrendingResponse> call, Response<TrendingResponse> response) {
//                if(response.isSuccessful() && response.code() == 200){
//                    TrendingResponse trendingAllOfDay = response.body();
//                    progressDialog.dismiss();
//                    Log.d("Trending all of day", "onResponse: " + trendingAllOfDay.getTrendingResult());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<TrendingResponse> call, Throwable t) {
//                progressDialog.hide();
//                Utility.showLongToast(TrendingActivity.this, t.getMessage());
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textBtnTrendingAll:
                replaceTrendActivityToTrendindAllFrag(new TrendingAllFrag());
                break;
            case R.id.textBtnPerson:
                replaceTrendActivityToTrendingPersonFrag(new TrendingPersonFrag());
                break;
            case R.id.textBtnTrendingTv:
                replaceTrendActivityToTrendingTVFrag(new TrendingTVFrag());
                break;
            case R.id.textBtnTrendingMovie:
                replaceTrendActivityToTrendindMovieFrag(new TrendMovieFrag());
                break;
        }
    }

    private void replaceTrendActivityToTrendindMovieFrag(TrendMovieFrag trendMovieFrag) {
        progressDialog.dismiss();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_view_tag_of_trending, trendMovieFrag);
        fragmentTransaction.commit();
    }

    private void replaceTrendActivityToTrendingTVFrag(TrendingTVFrag trendingTVFrag) {
        progressDialog.dismiss();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_view_tag_of_trending, trendingTVFrag);
        fragmentTransaction.commit();
    }

    private void replaceTrendActivityToTrendingPersonFrag(TrendingPersonFrag trendingPersonFrag) {

        progressDialog.dismiss();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container_view_tag_of_trending, trendingPersonFrag);
        fragmentTransaction.commit();
    }

    private void replaceTrendActivityToTrendindAllFrag(TrendingAllFrag trendingAllFrag) {

        progressDialog.dismiss();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container_view_tag_of_trending, trendingAllFrag);
        fragmentTransaction.commit();
    }
}