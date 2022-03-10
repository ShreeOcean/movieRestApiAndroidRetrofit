package com.movierestapicall.interfaces;

import com.movierestapicall.response.pojo.PopularMovieResultsPOJO;

import java.util.List;

public interface OnItemClickListener {

    void onItemClick(List<PopularMovieResultsPOJO> popularMovieList, int position);
}
