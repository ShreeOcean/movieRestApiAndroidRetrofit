package com.movierestapicall.interfaces;

import com.movierestapicall.response.MoviePopularResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiName {

        @GET("/movie/popular")
        Call<List<MoviePopularResponse>> getPopularMovie(@Query("api_key") String cd852112b111a64a51cb4cade02819d8);
//    @GET("/posts")
//    Call<List<PostResposnse>> getPostsData();
//
//
//    @GET("/comments")
//    Call<List<CommentsResponse>> getCommentsData();
//
//    @GET("/albums")
//    Call<List<AlbumsResponse>> getAlbumsData();
//
//    @GET("/photos")
//    Call<List<PhotoResponse>> getPhotoData();
//
//    @GET("/todos")
//    Call<List<TodoResponse>> getTodoData();
//
//    @GET("/users")
//    Call<List<UserDetailsResponse>> getUsersData();
}
