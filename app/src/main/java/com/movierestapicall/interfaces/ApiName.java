package com.movierestapicall.interfaces;

import com.movierestapicall.response.MoviePopularResponse;
import com.movierestapicall.response.PopularPersonResponse;
import com.movierestapicall.response.TrendingResponse;
import com.movierestapicall.response.pojo.PopularMovieResultsPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiName {

        @GET("/3/movie/popular?")
        Call<MoviePopularResponse> getPopularMovie(@Query("api_key") String apiKey);

        @GET("/3/trending/movie/week")
        Call<TrendingResponse> getTrendingMovieOfWeek(@Query("api_key") String apikey);

        @GET("/3/trending/movie/day")
        Call<TrendingResponse> getTrendingMovieOfDay(@Query("api_key") String apikey);

        @GET("/3/trending/all/week")
        Call<TrendingResponse> getTrendingAllOfWeek(@Query("api_key") String apikey);

        @GET("/3/trending/all/day")
        Call<TrendingResponse> getTrendingAllOfDay(@Query("api_key") String apikey);

        @GET("/3/trending/tv/day")
        Call<TrendingResponse> getTrendingTvOfDay(@Query("api_key") String apikey);

        @GET("/3/trending/tv/week")
        Call<TrendingResponse> getTrendingTvOfWeek(@Query("api_key") String apikey);

        @GET("/3/trending/person/day")
        Call<TrendingResponse> getTrendingPersonOfDay(@Query("api_key") String apikey);

        @GET("/3/trending/person/week")
        Call<TrendingResponse> getTrendingPersonOfWeek(@Query("api_key") String apikey);

        @GET("/3/person/popular")
        Call<PopularPersonResponse> getPopularPerson(@Query("api_key") String apikey);



}
