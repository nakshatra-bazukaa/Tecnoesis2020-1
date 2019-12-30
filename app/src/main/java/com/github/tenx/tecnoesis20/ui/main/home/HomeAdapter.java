package com.github.tenx.tecnoesis20.ui.main.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.data.models.HomeEventBody;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ImageViewHOlder> {

    private Context tcontext;
    private List<HomeEventBody> hlist;

    public HomeAdapter(Context tcontext) {
        this.tcontext = tcontext;
        this.hlist =  new ArrayList<>();
    }


    public void setHlist(List<HomeEventBody> hlist) {
        this.hlist = hlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_home_events,parent,false);
        return new ImageViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHOlder holder, final int position) {
        HomeEventBody currentData = hlist.get(position);

        holder.tvName.setText(currentData.getName());
        holder.tvDescription.setText(currentData.getDescription());
        Glide.with(tcontext).load(currentData.getImage()).placeholder(R.drawable.placeholder_image).into(holder.ivImage);

    }

    @Override
    public int getItemCount()
    {
        return hlist == null ? 0 : hlist.size();
    }

    public  class ImageViewHOlder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_home_event_image)
        ImageView ivImage;

        @BindView(R.id.tv_home_module_title)
        TextView tvName;
        @BindView(R.id.tv_home_description)
        TextView tvDescription;

        public ImageViewHOlder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}

