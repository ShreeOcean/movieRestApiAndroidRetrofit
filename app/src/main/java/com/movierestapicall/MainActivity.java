package com.movierestapicall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.movierestapicall.adapter.CustomListViewAdapter;
import com.movierestapicall.databinding.ActivityMainBinding;
import com.movierestapicall.interfaces.ApiName;
import com.movierestapicall.response.MoviePopularResponse;
import com.movierestapicall.utility.Utility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    ProgressDialog progressDialog;
    CustomListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<MoviePopularResponse>> call = apiName.getPopularMovie("cd852112b111a64a51cb4cade02819d8");
        call.enqueue(new Callback<List<MoviePopularResponse>>() {
            @Override
            public void onResponse(Call<List<MoviePopularResponse>> call, Response<List<MoviePopularResponse>> response) {
                if (response.isSuccessful() && response.code() == 200){
                    List<MoviePopularResponse> moviePopularResponses = response.body();
                    for (MoviePopularResponse popularResponse : moviePopularResponses){
                        progressDialog.hide();
                        listViewAdapter =new CustomListViewAdapter( moviePopularResponses, getApplicationContext());
                        mainBinding.listViewMovie.setAdapter(listViewAdapter);

                        Log.d("POPULAR MOVIE :", "onResponse: ------>" + popularResponse.getPage() + "\n" + popularResponse.getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<MoviePopularResponse>> call, Throwable t) {
                progressDialog.hide();
                Utility.showLongToast(MainActivity.this, t.getMessage());
            }
        });
    }
}