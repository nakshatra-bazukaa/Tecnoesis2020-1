package com.github.tenx.tecnoesis20.ui.main.about.teams;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.ui.main.home.HomeEventAdapter;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private ArrayList<String> mTeamHeader = new ArrayList<>();
    private ArrayList<ArrayList<String>> mTeamItemImageUrl = new ArrayList<>();
    private ArrayList<ArrayList<String>> mTeamItemName = new ArrayList<>();
    private ArrayList<ArrayList<String>> mTeamItemDesignation = new ArrayList<>();
    private Context mContext;
    private TeamItemAdapter gridAdapter;

    public TeamAdapter(Context mContext, ArrayList<String> mTeamHeader, ArrayList<ArrayList<String>> mTeamItemImageUrl, ArrayList<ArrayList<String>> mTeamItemName, ArrayList<ArrayList<String>> mTeamItemDesignation) {
        this.mTeamHeader = mTeamHeader;
        this.mTeamItemImageUrl = mTeamItemImageUrl;
        this.mTeamItemName = mTeamItemName;
        this.mTeamItemDesignation = mTeamItemDesignation;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.about_team,parent,false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {

        holder.teamHeader.setText(mTeamHeader.get(position));

        gridAdapter = new TeamItemAdapter(mContext, mTeamItemImageUrl.get(position), mTeamItemName.get(position), mTeamItemDesignation.get(position));
        holder.itemRecyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
        holder.itemRecyclerView.setAdapter(gridAdapter);

    }

    @Override
    public int getItemCount() {
        return mTeamHeader.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder{

        private TextView teamHeader;
        private RecyclerView itemRecyclerView;


        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);

            teamHeader = itemView.findViewById(R.id.team_about_tv_header);

            itemRecyclerView = itemView.findViewById(R.id.team_about_rv_teamItems);
        }
    }
}
