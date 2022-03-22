package com.movierestapicall.response;

import com.google.gson.annotations.SerializedName;
import com.movierestapicall.response.pojo.TrendingResultsPOJO;
import com.movierestapicall.response.pojo.TrendingTVResultsPOJO;

import java.util.List;

public class TrendingTVResponse {

    @SerializedName("page")
    private int trendingPage;

    @SerializedName("results")
    private List<TrendingTVResultsPOJO> trendingTVResult;

    @SerializedName("total_pages")
    private int totalPage;

    @SerializedName("total_results")
    private int totalResult;

    public int getTrendingPage() {
        return trendingPage;
    }

    public List<TrendingTVResultsPOJO> getTrendingTVResult() {
        return trendingTVResult;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalResult() {
        return totalResult;
    }
}
