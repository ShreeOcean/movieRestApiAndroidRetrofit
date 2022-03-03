package com.movierestapicall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.movierestapicall.adapter.CustomListViewAdapter;
import com.movierestapicall.databinding.ActivityMainBinding;
import com.movierestapicall.interfaces.ApiName;
import com.movierestapicall.response.MoviePopularResponse;

import java.util.List;

import retrofit2.Call;
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
        //Call<List<MoviePopularResponse>> call = apiName.getPopularMovie();
    }
}