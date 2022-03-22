package com.movierestapicall.response;

import com.google.gson.annotations.SerializedName;
import com.movierestapicall.response.pojo.TrendingMoviePojo;

import java.util.List;

public class TrendingMovieResponse {
    @SerializedName("page")
    private Integer page;
    @SerializedName("results")
    private List<TrendingMoviePojo> results = null;
    @SerializedName("total_pages")
    private Integer totalPages;
    @SerializedName("total_results")
    private Integer totalResults;

    public Integer getPage() {
        return page;
    }

    public List<TrendingMoviePojo> getResults() {
        return results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }
}
