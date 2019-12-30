package com.github.tenx.tecnoesis20.ui.main.home;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.tenx.tecnoesis20.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class SponsorsAdapter extends RecyclerView.Adapter<SponsorsAdapter.ImageViewHOlder> {

    private Context tcontext;
    private List<String> hlist;

    public SponsorsAdapter(Context tcontext) {
        this.tcontext = tcontext;
        this.hlist = new ArrayList<>();
    }

    @NonNull
    @Override
    public ImageViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_sponsors_item,parent,false);
        return new ImageViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHOlder holder, final int position) {
       Glide.with(tcontext).load(hlist.get(position)).placeholder(R.drawable.placeholder_image).into(holder.imageView);

    }

    @Override
    public int getItemCount()
    {
        return hlist == null ? 0 :  hlist.size();
    }

    public void setHlist(List<String> hlist) {
        this.hlist = hlist;
        notifyDataSetChanged();
    }

    public  class ImageViewHOlder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_sponsors_home_events)
        ImageView imageView;


        public ImageViewHOlder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
