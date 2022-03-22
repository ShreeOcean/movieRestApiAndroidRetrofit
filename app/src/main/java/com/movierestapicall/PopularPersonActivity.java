package com.movierestapicall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.movierestapicall.adapter.PopularPersonListAdapeter;
import com.movierestapicall.databinding.ActivityPopularPersonBinding;
import com.movierestapicall.interfaces.ApiName;
import com.movierestapicall.response.PopularPersonResponse;
import com.movierestapicall.response.pojo.PopularPersonResultsPOJO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.movierestapicall.utility.Utility;

public class PopularPersonActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    ActivityPopularPersonBinding personBinding;
    PopularPersonListAdapeter listAdapeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        personBinding = ActivityPopularPersonBinding.inflate(getLayoutInflater());
        setContentView(personBinding.getRoot());

        personBinding.recyclerViewOfPopularPerson.setLayoutManager(new GridLayoutManager(this, GridLayoutManager.VERTICAL));

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<PopularPersonResponse> call = apiName.getPopularPerson(Utility.KEY);
        call.enqueue(new Callback<PopularPersonResponse>() {
            @Override
            public void onResponse(Call<PopularPersonResponse> call, Response<PopularPersonResponse> response) {
                if(response.isSuccessful() && response.code() == 200){
                    progressDialog.dismiss();
                    PopularPersonResponse personResponse = response.body();
                    assert personResponse != null;
                    listAdapeter = new PopularPersonListAdapeter( personResponse.getPopularPersonResult(),PopularPersonActivity.this);
                    personBinding.recyclerViewOfPopularPerson.setAdapter(listAdapeter);
                    listAdapeter.notifyDataSetChanged();

                    Log.d("PopularPersonActivity", "onResponse: " + personResponse.getPopularPersonResult());
                }
            }

            @Override
            public void onFailure(Call<PopularPersonResponse> call, Throwable t) {
                Utility.showLongToast(PopularPersonActivity.this, t.getMessage());
            }
        });
    }
}