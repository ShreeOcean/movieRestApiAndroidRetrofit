package com.movierestapicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.movierestapicall.databinding.CustomTrendingTvItemBinding;
import com.movierestapicall.response.pojo.TrendingTVResultsPOJO;
import com.movierestapicall.utility.Utility;

import java.util.List;


public class TrendingTvRecyclerAdapter extends RecyclerView.Adapter<TrendingTvRecyclerAdapter.MyViewHolder> {

    Context context;
    List<TrendingTVResultsPOJO> list;
    CustomTrendingTvItemBinding tvItemBinding;

    public TrendingTvRecyclerAdapter(Context context, List<TrendingTVResultsPOJO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TrendingTvRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        tvItemBinding = CustomTrendingTvItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(tvItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingTvRecyclerAdapter.MyViewHolder holder, int position) {
        String imagePoster = Utility.IMAGE_BASE_URL + list.get(position).getPosterPath();
        String imageBackground = Utility.IMAGE_BASE_URL + list.get(position).getBackdropPath();

        Glide.with(context).load(imageBackground).into(holder.tvItemBinding.imageViewBackdropTrendingTv);
        Glide.with(context).load(imagePoster).into(holder.tvItemBinding.imageViewPosterTrendingTv);

        holder.tvItemBinding.tvTrendingTvOriginalName.setText(list.get(position).getOriginalName());
        holder.tvItemBinding.tvTrendingName.setText("Name : "+list.get(position).getName());
        holder.tvItemBinding.tvTrendingOverview.setText("Overview :  "+list.get(position).getOverview());
        holder.tvItemBinding.tvFirstAirDate.setText("First Air Date : "+list.get(position).getFirstAirDate());
        holder.tvItemBinding.tvTrendingRating.setText("Ratings : "+list.get(position).getVoteAverage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CustomTrendingTvItemBinding tvItemBinding;
        public MyViewHolder(CustomTrendingTvItemBinding itemView) {
            super(itemView.getRoot());
            tvItemBinding = itemView;
        }
    }
}
