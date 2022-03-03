package com.movierestapicall.response;

import com.google.gson.annotations.SerializedName;
import com.movierestapicall.response.pojo.ResultPojo;

import java.util.List;

public class MoviePopularResponse {

    @SerializedName("page")
    private Integer page;

    @SerializedName("results")
    private List<ResultPojo> results;

    @SerializedName("total_pages")
    private Integer totalPages;

    @SerializedName("total_results")
    private Integer totalResults;

    public MoviePopularResponse(Integer page, List<ResultPojo> results, Integer totalPages, Integer totalResults) {
        this.page = page;
        this.results = results;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }

    public Integer getPage() {
        return page;
    }

    public List<ResultPojo> getResults() {
        return results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }
}
