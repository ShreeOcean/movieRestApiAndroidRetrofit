package com.movierestapicall.interfaces;

import com.movierestapicall.response.pojo.PopularMovieResultsPOJO;
import com.movierestapicall.response.pojo.PopularPersonResultsPOJO;

import java.util.List;

public interface OnItemClickListener {

    void onItemClick(List<PopularMovieResultsPOJO> popularMovieList, int position);

    void onItemClickPopPerson(List<PopularPersonResultsPOJO> popularPersonResultsPOJOS, int position);
}
