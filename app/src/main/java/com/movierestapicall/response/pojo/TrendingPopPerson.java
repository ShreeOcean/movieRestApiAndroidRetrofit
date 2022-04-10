package com.movierestapicall.response.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrendingPopPerson {

    @SerializedName("adult")
    private Boolean adult;
    @SerializedName("known_for")
    private List<KnownFor> knownFor = null;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private Integer id;
    @SerializedName("profile_path")
    private String profilePath;
    @SerializedName("gender")
    private Integer gender;
    @SerializedName("known_for_department")
    private String knownForDepartment;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("media_type")
    private String mediaType;

    public Boolean getAdult() {
        return adult;
    }

    public List<KnownFor> getKnownFor() {
        return knownFor;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public Integer getGender() {
        return gender;
    }

    public String getKnownForDepartment() {
        return knownForDepartment;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getMediaType() {
        return mediaType;
    }
}
