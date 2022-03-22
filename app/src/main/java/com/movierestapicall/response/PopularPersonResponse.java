package com.movierestapicall.response;

import com.google.gson.annotations.SerializedName;
import com.movierestapicall.response.pojo.PopularPersonResultsPOJO;

import java.util.List;

public class PopularPersonResponse {

    @SerializedName("page")
    private int popularPersonPage;

    @SerializedName("results")
    private List<PopularPersonResultsPOJO> popularPersonResult;

    @SerializedName("total_pages")
    private int popularPersonTotalPages;

    @SerializedName("total_results")
    private int popularPersonTotalResults;

    public int getPopularPersonPage() {
        return popularPersonPage;
    }

    public List<PopularPersonResultsPOJO> getPopularPersonResult() {
        return popularPersonResult;
    }

    public int getPopularPersonTotalPages() {
        return popularPersonTotalPages;
    }

    public int getPopularPersonTotalResults() {
        return popularPersonTotalResults;
    }
}
