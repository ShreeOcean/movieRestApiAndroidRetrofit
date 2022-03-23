package com.movierestapicall.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.movierestapicall.databinding.CustomTrendingPeopleListviewItemBinding;
import com.movierestapicall.fragment.FragPopPersonDetails;
import com.movierestapicall.response.PopularPersonResponse;
import com.movierestapicall.response.pojo.PopularPersonResultsPOJO;
import com.movierestapicall.utility.Utility;

import android.content.Context;
import java.util.List;


public class PopularPersonListAdapeter extends RecyclerView.Adapter<PopularPersonListAdapeter.MyViewHolder>{

    private List<PopularPersonResultsPOJO> list;
    Context context;
    CustomTrendingPeopleListviewItemBinding itemBinding;

    public PopularPersonListAdapeter(List<PopularPersonResultsPOJO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PopularPersonListAdapeter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemBinding = CustomTrendingPeopleListviewItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new PopularPersonListAdapeter.MyViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularPersonListAdapeter.MyViewHolder holder, int position) {



        String profileDP = Utility.IMAGE_BASE_URL + list.get(position).getProfilePath();
        Glide.with(context).load(profileDP).into(holder.itemBinding.imageViewPopularPerson);

        holder.itemBinding.textViewTrendingPeopleName.setText(list.get(position).getName());
        holder.itemBinding.textViewTrendingPeopleWork.setText("Profession : " + list.get(position).getKnownForDepartment());

//        holder.itemView.setOnClickListener(view -> {
//            replaceActivityToFrag(new FragPopPersonDetails(position));
//        });

    }

//    private void replaceActivityToFrag(FragPopPersonDetails fragPopPersonDetails) {
//    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CustomTrendingPeopleListviewItemBinding itemBinding;
        public MyViewHolder(CustomTrendingPeopleListviewItemBinding itemView) {
            super(itemView.getRoot());
            itemBinding = itemView;
        }
    }
}
