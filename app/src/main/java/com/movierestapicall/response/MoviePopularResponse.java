package com.movierestapicall.response;

import com.google.gson.annotations.SerializedName;
import com.movierestapicall.response.pojo.PopularMovieResultsPOJO;

import java.util.List;

public class MoviePopularResponse {

    @SerializedName("page")
    private int PopularMoviesPage;

    @SerializedName("results")
    private List<PopularMovieResultsPOJO>  PopularMoviesResult;

    @SerializedName("total_pages")
    private int PopularMoviesTotalPages;

    @SerializedName("total_results")
    private int PopularMoviesTotalResults;

    public MoviePopularResponse(int popularMoviesPage, List<PopularMovieResultsPOJO> popularMoviesResult, int popularMoviesTotalPages, int popularMoviesTotalResults) {
        PopularMoviesPage = popularMoviesPage;
        PopularMoviesResult = popularMoviesResult;
        PopularMoviesTotalPages = popularMoviesTotalPages;
        PopularMoviesTotalResults = popularMoviesTotalResults;
    }

    public int getPopularMoviesPage() {
        return PopularMoviesPage;
    }

    public List<PopularMovieResultsPOJO> getPopularMoviesResult() {
        return PopularMoviesResult;
    }

    public int getPopularMoviesTotalPages() {
        return PopularMoviesTotalPages;
    }

    public int getPopularMoviesTotalResults() {
        return PopularMoviesTotalResults;
    }
}
