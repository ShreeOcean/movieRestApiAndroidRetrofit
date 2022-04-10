package com.movierestapicall.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.movierestapicall.R;
import com.movierestapicall.databinding.CustomListviewTrendingBinding;
import com.movierestapicall.databinding.CustomTrendingPeopleListviewItemBinding;
import com.movierestapicall.response.pojo.PopularPersonResultsPOJO;
import com.movierestapicall.response.pojo.TrendingPopPerson;
import com.movierestapicall.utility.Utility;
import java.util.List;
import android.content.Context;

public class TrendingPersonRecyclerAdapter extends RecyclerView.Adapter<TrendingPersonRecyclerAdapter.MyViewHolder>{

    private Context context;
    private List<PopularPersonResultsPOJO> personResultsPOJOList;
    CustomTrendingPeopleListviewItemBinding itemBinding;

    public TrendingPersonRecyclerAdapter(Context context, List<PopularPersonResultsPOJO> personResultsPOJOList) {
        this.context = context;
        this.personResultsPOJOList = personResultsPOJOList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemBinding = CustomTrendingPeopleListviewItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new TrendingPersonRecyclerAdapter.MyViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String profileDP = Utility.IMAGE_BASE_URL + personResultsPOJOList.get(position).getProfilePath();
        Glide.with(context).load(profileDP).into(holder.itemBinding.imageViewPopularPerson);

        holder.itemBinding.textViewTrendingPeopleName.setText(personResultsPOJOList.get(position).getName());
        holder.itemBinding.textViewTrendingPeopleWork.setText("Profession : " + personResultsPOJOList.get(position).getKnownForDepartment());
    }

    @Override
    public int getItemCount() {
        return personResultsPOJOList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CustomTrendingPeopleListviewItemBinding itemBinding;
        public MyViewHolder(CustomTrendingPeopleListviewItemBinding itemView) {
            super(itemView.getRoot());
            itemBinding = itemView;
        }
    }
}
