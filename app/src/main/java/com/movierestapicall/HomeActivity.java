package com.movierestapicall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.movierestapicall.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityHomeBinding homeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(homeBinding.getRoot());

        homeBinding.popularMovieBtn.setOnClickListener(this);
        homeBinding.trendingBtn.setOnClickListener(this);
        homeBinding.popularPersonBtn.setOnClickListener(this);
        homeBinding.rateMovieBtn.setOnClickListener(this);

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
            case R.id.popular_person_btn:
                startActivity(new Intent(HomeActivity.this, PopularPersonActivity.class));
                break;
            case R.id.rate_movie_btn:
                Toast.makeText(this, "THIS FEATURE IS COMING SOON ...", Toast.LENGTH_LONG).show();
                break;
        }
    }
}