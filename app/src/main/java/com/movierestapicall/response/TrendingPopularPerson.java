package com.movierestapicall.response;

import com.google.gson.annotations.SerializedName;
import com.movierestapicall.response.pojo.PopularMovieResultsPOJO;
import com.movierestapicall.response.pojo.PopularPersonResultsPOJO;

import java.util.List;

public class TrendingPopularPerson {

    @SerializedName("page")
    private int PopularMoviesPage;

    @SerializedName("results")
    private List<PopularPersonResultsPOJO> PopularMoviesResult;

    @SerializedName("total_pages")
    private int PopularMoviesTotalPages;

    @SerializedName("total_results")
    private int PopularMoviesTotalResults;

    public int getPopularMoviesPage() {
        return PopularMoviesPage;
    }

    public List<PopularPersonResultsPOJO> getPopularMoviesResult() {
        return PopularMoviesResult;
    }

    public int getPopularMoviesTotalPages() {
        return PopularMoviesTotalPages;
    }

    public int getPopularMoviesTotalResults() {
        return PopularMoviesTotalResults;
    }
}
