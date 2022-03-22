package com.movierestapicall.response.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PopularPersonResultsPOJO {

    @SerializedName("adult")
    @Expose
    private Boolean adult;
    @SerializedName("gender")
    @Expose
    private Integer gender;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("known_for")
    @Expose
    private List<KnownFor> knownFor = null;
    @SerializedName("known_for_department")
    @Expose
    private String knownForDepartment;
    @SerializedName("profile_path")
    @Expose
    private String profilePath;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("media_type")
    @Expose
    private String mediaType;

    public Boolean getAdult() {
        return adult;
    }

    public Integer getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public List<KnownFor> getKnownFor() {
        return knownFor;
    }

    public String getKnownForDepartment() {
        return knownForDepartment;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getMediaType() {
        return mediaType;
    }
}
