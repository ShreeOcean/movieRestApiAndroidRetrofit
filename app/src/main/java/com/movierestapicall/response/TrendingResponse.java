package com.movierestapicall.response;

import com.google.gson.annotations.SerializedName;
import com.movierestapicall.response.pojo.PopularMovieResultsPOJO;
import com.movierestapicall.response.pojo.TrendingResultsPOJO;

import java.util.List;

public class TrendingResponse {

    @SerializedName("page")
    private int trendingPage;

    @SerializedName("results")
    private List<TrendingResultsPOJO> trendingResult;

    @SerializedName("total_pages")
    private int totalPage;

    @SerializedName("total_results")
    private int totalResult;

    public TrendingResponse(int trendingPage, List<TrendingResultsPOJO> trendingResult, int totalPage, int totalResult) {
        this.trendingPage = trendingPage;
        this.trendingResult = trendingResult;
        this.totalPage = totalPage;
        this.totalResult = totalResult;
    }

    public int getTrendingPage() {
        return trendingPage;
    }

    public void setTrendingPage(int trendingPage) {
        this.trendingPage = trendingPage;
    }

    public List<TrendingResultsPOJO> getTrendingResult() {
        return trendingResult;
    }

    public void setTrendingResult(List<TrendingResultsPOJO> trendingResult) {
        this.trendingResult = trendingResult;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }
}
