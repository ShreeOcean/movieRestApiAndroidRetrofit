package com.movierestapicall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.movierestapicall.databinding.ActivityTrendingBinding;
import com.movierestapicall.interfaces.ApiName;
import com.movierestapicall.response.TrendingResponse;
import com.movierestapicall.utility.Utility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendingActivity extends AppCompatActivity {

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
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<TrendingResponse> call = apiName.getTrendingAllOfDay(Utility.KEY);
        call.enqueue(new Callback<TrendingResponse>() {
            @Override
            public void onResponse(Call<TrendingResponse> call, Response<TrendingResponse> response) {
                if(response.isSuccessful() && response.code() == 200){
                    TrendingResponse trendingAllOfDay = response.body();
                    progressDialog.dismiss();
                    Log.d("Trending all of day", "onResponse: " + trendingAllOfDay.getTrendingResult());
                }
            }

            @Override
            public void onFailure(Call<TrendingResponse> call, Throwable t) {
                progressDialog.hide();
                Utility.showLongToast(TrendingActivity.this, t.getMessage());
            }
        });
    }
}