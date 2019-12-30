package com.github.tenx.tecnoesis20.ui.main.about.teams;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.tecnoesis20.R;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private ArrayList<String> mTeamHeader = new ArrayList<>();
    private ArrayList<ArrayList<String>> mTeamMemberImage = new ArrayList<>();
    private ArrayList<ArrayList<String>> mTeamMemberName = new ArrayList<>();
    private ArrayList<ArrayList<String>> mTeamMemberDesignation = new ArrayList<>();

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.about_team,parent,false);
        TeamViewHolder holder = new TeamViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder{

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
