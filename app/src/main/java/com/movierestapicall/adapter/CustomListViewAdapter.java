package com.movierestapicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.movierestapicall.R;
import com.movierestapicall.response.MoviePopularResponse;

import java.util.List;

public class CustomListViewAdapter extends BaseAdapter {

    private List<MoviePopularResponse> list;
    private Context context;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //Todo: code for list view implementation
        TextView tvMovieTiltl, tvMovieOriTitle, tvAdult, tvOverview, tvReleaseDate, tvOriLanguage, tvPopularity, tvVoteCount, tvVoteAvg;
        ImageView imageView_poster, imageView_backdrop;

        view = LayoutInflater.from(context).inflate(R.layout.custom_listview_item_movie,viewGroup,false);

        tvAdult = view.findViewById(R.id.tv_adult);
        tvMovieOriTitle = view.findViewById(R.id.tv_movie_title);
        tvMovieTiltl = view.findViewById(R.id.tv_title);
        tvOriLanguage = view.findViewById(R.id.tv_original_language);
        tvOverview = view.findViewById(R.id.tv_overview);
        tvPopularity = view.findViewById(R.id.tv_popularity);
        tvReleaseDate = view.findViewById(R.id.tv_release_date);
        tvVoteAvg = view.findViewById(R.id.tv_vote_avg);
        tvVoteCount = view.findViewById(R.id.tv_vote_count);
        imageView_backdrop = view.findViewById(R.id.imageView_backdrop);
        imageView_poster = view.findViewById(R.id.imageView_poster_path);

        MoviePopularResponse moPoResData = list.get(i);

        //tvAdult.setText(moPoResData.getResults().);
        return view;
    }
}
