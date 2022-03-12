package com.movierestapicall.response.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrendingResultsPOJO {

        @SerializedName("release_date")
        private String releaseDate;

        @SerializedName("title")
        private String title;

        @SerializedName("adult")
        private Boolean adult;

        @SerializedName("backdrop_path")
        private String backdropPath;

        @SerializedName("genre_ids")
        private List<Integer> genreIds = null;

        @SerializedName("original_language")
        private String originalLanguage;

        @SerializedName("original_title")
        private String originalTitle;

        @SerializedName("poster_path")
        private String posterPath;

        @SerializedName("vote_count")
        private Integer voteCount;

        @SerializedName("video")
        private Boolean video;

        @SerializedName("id")
        private Integer id;

        @SerializedName("vote_average")
        private Double voteAverage;

        @SerializedName("overview")
        private String overview;

        @SerializedName("popularity")
        private Double popularity;

        @SerializedName("media_type")
        private String mediaType;

        @SerializedName("first_air_date")
        private String firstAirDate;

        @SerializedName("name")
        private String name;

        @SerializedName("original_name")
        private String originalName;

        @SerializedName("origin_country")
        private List<String> originCountry = null;

    public TrendingResultsPOJO(String releaseDate, String title, Boolean adult, String backdropPath, List<Integer> genreIds, String originalLanguage, String originalTitle, String posterPath, Integer voteCount, Boolean video, Integer id, Double voteAverage, String overview, Double popularity, String mediaType, String firstAirDate, String name, String originalName, List<String> originCountry) {
        this.releaseDate = releaseDate;
        this.title = title;
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.genreIds = genreIds;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.posterPath = posterPath;
        this.voteCount = voteCount;
        this.video = video;
        this.id = id;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.popularity = popularity;
        this.mediaType = mediaType;
        this.firstAirDate = firstAirDate;
        this.name = name;
        this.originalName = originalName;
        this.originCountry = originCountry;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getAdult() {
        return adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public Boolean getVideo() {
        return video;
    }

    public Integer getId() {
        return id;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }
}
