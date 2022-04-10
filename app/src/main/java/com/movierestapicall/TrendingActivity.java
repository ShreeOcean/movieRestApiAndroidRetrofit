package com.movierestapicall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
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
    TrendingAllFrag trendingAllFrag = new TrendingAllFrag();
    TrendingPersonFrag trendingPersonFrag = new TrendingPersonFrag();
    TrendingTVFrag trendingTVFrag = new TrendingTVFrag();
    TrendMovieFrag trendMovieFrag = new TrendMovieFrag();
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
        replaceFragment(new TrendingAllFrag());
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textBtnTrendingAll:
                replaceFragment(trendingAllFrag);
                break;
            case R.id.textBtnPerson:
                replaceFragment(trendingPersonFrag);
                break;
            case R.id.textBtnTrendingTv:
                replaceFragment(trendingTVFrag);
                break;
            case R.id.textBtnTrendingMovie:
                replaceFragment(trendMovieFrag);
                break;
        }
    }

    private void replaceFragment(Fragment fragment){
        progressDialog.dismiss();
        getSupportFragmentManager()
                .beginTransaction().
                replace(R.id.fragment_container_view_tag_of_trending,fragment)
                .commit();
    }
}