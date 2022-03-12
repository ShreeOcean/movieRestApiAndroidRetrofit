package com.movierestapicall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.movierestapicall.adapter.CustomListViewAdapter;
import com.movierestapicall.adapter.ListViewCustomAdapterRecycler;
import com.movierestapicall.databinding.ActivityMainBinding;
import com.movierestapicall.interfaces.ApiName;
import com.movierestapicall.response.MoviePopularResponse;
import com.movierestapicall.response.pojo.PopularMovieResultsPOJO;
import com.movierestapicall.utility.Utility;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    ProgressDialog progressDialog;
    CustomListViewAdapter listViewAdapter;
    ListViewCustomAdapterRecycler adapterRecycler;
    RecyclerView popularMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        mainBinding.recyclerViewFromMainActivity.setLayoutManager(new LinearLayoutManager(this));
        //popularMovie = mainBinding.recyclerViewFromMainActivity;

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);

        Call<MoviePopularResponse> call =apiName.getPopularMovie(Utility.KEY);
        call.enqueue(new Callback<MoviePopularResponse>() {
            @Override
            public void onResponse(Call<MoviePopularResponse> call, Response<MoviePopularResponse> response) {
                if(response.isSuccessful() && response.code() == 200){
                    MoviePopularResponse popularMovieList = response.body();
                    for (PopularMovieResultsPOJO popularMovie : popularMovieList.getPopularMoviesResult()){
                        progressDialog.dismiss();
                        adapterRecycler = new ListViewCustomAdapterRecycler(MainActivity.this, popularMovieList.getPopularMoviesResult());
                        mainBinding.recyclerViewFromMainActivity.setAdapter(adapterRecycler);
                        adapterRecycler.notifyDataSetChanged();

                        Log.d("Popular Movie", "onResponse: " + popularMovie.getOriginalTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<MoviePopularResponse> call, Throwable t) {
                progressDialog.hide();
                Utility.showLongToast(MainActivity.this, t.getMessage());
            }
        });

    }
}