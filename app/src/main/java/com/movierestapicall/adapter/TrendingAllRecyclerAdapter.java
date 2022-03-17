package com.movierestapicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.movierestapicall.databinding.CustomListviewItemMovieBinding;
import com.movierestapicall.databinding.CustomListviewTrendingBinding;
import com.movierestapicall.response.pojo.PopularMovieResultsPOJO;
import com.movierestapicall.response.pojo.TrendingResultsPOJO;
import com.movierestapicall.utility.Utility;

import java.util.List;

public class TrendingAllRecyclerAdapter extends RecyclerView.Adapter<TrendingAllRecyclerAdapter.MyViewHolder> {

    private Context context;
    private List<TrendingResultsPOJO> list;
    CustomListviewTrendingBinding trendingBinding;

    public TrendingAllRecyclerAdapter(Context context, List<TrendingResultsPOJO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        trendingBinding = CustomListviewTrendingBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(trendingBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String imagePoster = Utility.IMAGE_BASE_URL + list.get(position).getPosterPath();
        String imageBackground = Utility.IMAGE_BASE_URL + list.get(position).getBackdropPath();

        Glide.with(context).load(imageBackground).into(holder.trendingBinding.imageViewPosterPathTrending);
        Glide.with(context).load(imagePoster).into(holder.trendingBinding.imageViewBackdropTrending);

        holder.trendingBinding.tvOverviewTrending.setText(list.get(position).getOverview());
        holder.trendingBinding.tvTitleTrending.setText(list.get(position).getTitle());
        holder.trendingBinding.tvTrendingTitle.setText(list.get(position).getOriginalTitle());
       // holder.trendingBinding.tvPopularityTrending.setText(list.get(position).getPopularity());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        CustomListviewTrendingBinding trendingBinding;
        public MyViewHolder(CustomListviewTrendingBinding itemView) {
            super(itemView.getRoot());
            trendingBinding = itemView;
        }
    }
}
