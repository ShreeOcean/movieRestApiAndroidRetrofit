package com.movierestapicall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.movierestapicall.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityHomeBinding homeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(homeBinding.getRoot());

        homeBinding.popularMovieBtn.setOnClickListener(this::onClick);
        homeBinding.trendingBtn.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.trending_btn:
                startActivity(new Intent(HomeActivity.this, TrendingActivity.class));
                break;
            case R.id.popular_movie_btn:
                startActivity(new Intent(HomeActivity.this, PopularMovieActivity.class));
                break;

        }
    }
}