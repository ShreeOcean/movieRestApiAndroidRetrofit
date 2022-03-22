package com.movierestapicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.movierestapicall.databinding.CustomListviewItemMovieBinding;
import com.movierestapicall.response.pojo.TrendingMoviePojo;
import com.movierestapicall.utility.Utility;

import java.util.List;

public class TrendingMovieListAdapter extends RecyclerView.Adapter<TrendingMovieListAdapter.MyViewHolder> {

    Context context;
    private List<TrendingMoviePojo> list;
    CustomListviewItemMovieBinding movieBinding;

    public TrendingMovieListAdapter(Context context, List<TrendingMoviePojo> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TrendingMovieListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        movieBinding = CustomListviewItemMovieBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(movieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingMovieListAdapter.MyViewHolder holder, int position) {

        String backgroundImage = Utility.IMAGE_BASE_URL + list.get(position).getBackdropPath();
        String posterImage = Utility.IMAGE_BASE_URL + list.get(position).getPosterPath();
        Glide.with(context).load(posterImage).into(holder.movieBinding.imageViewBackdrop);
        Glide.with(context).load(backgroundImage).into(holder.movieBinding.imageViewPosterPath);

        holder.movieBinding.tvMovieTitle.setText(list.get(position).getOriginalTitle());
        holder.movieBinding.tvPopularity.setText("Popularity :  " + list.get(position).getPopularity().toString());
        holder.movieBinding.tvTitle.setText("Title : " + list.get(position).getTitle());
        holder.movieBinding.tvOverview.setText("Overview : " +"\n"+ list.get(position).getOverview());
        holder.movieBinding.tvVoteAvg.setText("Vote Avg : " + list.get(position).getVoteAverage());
        holder.movieBinding.tvVoteCount.setText("Vote Count : " + list.get(position).getVoteCount());
        holder.movieBinding.tvReleaseDate.setText("Release Date : " + list.get(position).getReleaseDate());
        holder.movieBinding.tvOriginalLanguage.setText("Original Language : " + list.get(position).getOriginalLanguage().toUpperCase());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class
    MyViewHolder extends RecyclerView.ViewHolder {
        CustomListviewItemMovieBinding movieBinding;
        public MyViewHolder(CustomListviewItemMovieBinding itemView) {
            super(itemView.getRoot());
            movieBinding = itemView;
        }
    }
}
