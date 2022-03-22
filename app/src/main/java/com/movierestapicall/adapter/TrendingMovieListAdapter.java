package com.movierestapicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.movierestapicall.databinding.CustomListviewItemMovieBinding;
import com.movierestapicall.response.pojo.TrendingMoviePojo;

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
        holder.movieBinding.tvMovieTitle.setText(list.get(position).getTitle());
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
        }
    }
}
