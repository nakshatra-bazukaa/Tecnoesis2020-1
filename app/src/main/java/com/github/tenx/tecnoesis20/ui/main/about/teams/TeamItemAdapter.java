package com.github.tenx.tecnoesis20.ui.main.about.teams;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.tenx.tecnoesis20.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeamItemAdapter extends RecyclerView.Adapter<TeamItemAdapter.TeamItemViewHolder> {

    private ArrayList<String> mImageUrl = new ArrayList<>();
    private ArrayList<String> mItemName = new ArrayList<>();
    private ArrayList<String> mItemDesignation = new ArrayList<>();
    private Context mContext;

    public TeamItemAdapter(Context mContext, ArrayList<String> mImageUrl, ArrayList<String> mItemName, ArrayList<String> mItemDesignation) {
        this.mImageUrl = mImageUrl;
        this.mItemName = mItemName;
        this.mItemDesignation = mItemDesignation;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public TeamItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team,parent,false);
        TeamItemViewHolder holder = new TeamItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamItemViewHolder holder, int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrl.get(position))
                .into(holder.itemImageView);
        holder.itemName.setText(mItemName.get(position));
        holder.itemDesignation.setText(mItemDesignation.get(position));

    }

    @Override
    public int getItemCount() {
        return mItemName.size();
    }

    public class TeamItemViewHolder extends RecyclerView.ViewHolder{

        CircleImageView itemImageView;
        TextView itemName;
        TextView itemDesignation;

        public TeamItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.item_team_civ_itemImage);
            itemName = itemView.findViewById(R.id.item_team_tv_itemName);
            itemDesignation = itemName.findViewById(R.id.item_team_tv_itemDesignation);
        }
    }
}
