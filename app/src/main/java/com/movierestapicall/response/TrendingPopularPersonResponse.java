package com.movierestapicall.response;

import com.google.gson.annotations.SerializedName;
import com.movierestapicall.response.pojo.PopularMovieResultsPOJO;
import com.movierestapicall.response.pojo.PopularPersonResultsPOJO;
import com.movierestapicall.response.pojo.TrendingPopPerson;

import java.util.List;

public class TrendingPopularPersonResponse {

    @SerializedName("page")
    private int PopularPersonPage;

    @SerializedName("results")
    private List<TrendingPopPerson> PopularPersonResult;

    @SerializedName("total_pages")
    private int PopularPersonTotalPages;

    @SerializedName("total_results")
    private int PopularPersonTotalResults;

    public int getPopularPersonPage() {
        return PopularPersonPage;
    }

    public List<TrendingPopPerson> getPopularPersonResult() {
        return PopularPersonResult;
    }

    public int getPopularPersonTotalPages() {
        return PopularPersonTotalPages;
    }

    public int getPopularPersonTotalResults() {
        return PopularPersonTotalResults;
    }
}
