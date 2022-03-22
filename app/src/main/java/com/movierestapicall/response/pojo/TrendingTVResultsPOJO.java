package com.movierestapicall.response.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrendingTVResultsPOJO {

    @SerializedName("first_air_date")
    private String firstAirDate;

    @SerializedName("id")
    private Integer id;

    @SerializedName("original_name")
    private String originalName;

    @SerializedName("origin_country")
    private List<String> originCountry = null;

    @SerializedName("genre_ids")
    private List<Integer> genreIds = null;

    @SerializedName("vote_count")
    private Integer voteCount;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("vote_average")
    private Double voteAverage;

    @SerializedName("overview")
    private String overview;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("name")
    private String name;

    @SerializedName("popularity")
    private Double popularity;

    @SerializedName("media_type")
    private String mediaType;

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public Integer getId() {
        return id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getName() {
        return name;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getMediaType() {
        return mediaType;
    }
}
