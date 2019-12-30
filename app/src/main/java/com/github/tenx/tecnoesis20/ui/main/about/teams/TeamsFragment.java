package com.github.tenx.tecnoesis20.ui.main.about.teams;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.tenx.tecnoesis20.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class TeamsFragment extends Fragment {

    private TeamsViewModel mViewModel;
    private ArrayList<String> mTeamHeader = new  ArrayList();
    private ArrayList<ArrayList<String>> mTeamItemImageUrl = new ArrayList<>();
    private ArrayList<ArrayList<String>> mTeamItemName = new ArrayList<>();
    private ArrayList<ArrayList<String>> mTeamItemDesignation = new ArrayList<>();


    @BindView(R.id.frag_teams_rv_team)
    RecyclerView teamRecyclerView;



    public static TeamsFragment newInstance() {
        return new TeamsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View parent = inflater.inflate(R.layout.fragment_teams, container, false);
        ButterKnife.bind(this,parent);
        return parent;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TeamsViewModel.class);
        // TODO: Use the ViewModel

    }

    @Override
    public void onStart() {
        super.onStart();

//        Dummy A
        ArrayList<String> tempItemImageUrl = new ArrayList<>();
        ArrayList<String> tempItemName = new ArrayList<>();
        ArrayList<String> tempItemDesignation = new ArrayList<>();

//        Dummy 1
        mTeamHeader.add("Android Team");



//        item 1
        tempItemImageUrl.add("https://yt3.ggpht.com/a-/AAuE7mD8j66Gv5r4oLf48Ij7PMljbIm_-GrASQ-CSA=s900-mo-c-c0xffffffff-rj-k-no");
        tempItemName.add("Bill Gates");
        tempItemDesignation.add("Bigger Billionaire");

//        item2
        tempItemImageUrl.add("https://tse3.mm.bing.net/th?id=OIP.6jjiDq38UkZtWSRJp6NMJwHaJb&pid=Api&P=0&w=300&h=300");
        tempItemName.add("Steve Jobs");
        tempItemDesignation.add("Billionaire");



        mTeamItemImageUrl.add(tempItemImageUrl);
        mTeamItemName.add(tempItemName);
        mTeamItemDesignation.add(tempItemDesignation);

//        Dummy B
        ArrayList<String> tempItemImageUrlB = new ArrayList<>();
        ArrayList<String> tempItemNameB = new ArrayList<>();
        ArrayList<String> tempItemDesignationB = new ArrayList<>();

//        Dummy 1
        mTeamHeader.add("Web Team");



//        item 1
        tempItemImageUrlB.add("https://tse3.mm.bing.net/th?id=OIP.CXJxyvRQ1fIHlf984SGv0AHaFj&pid=Api&P=0&w=225&h=170");
        tempItemNameB.add("Mark Zuckerberg");
        tempItemDesignationB.add("Bigger Billionaire");

//        item2
        tempItemImageUrlB.add("https://tse2.mm.bing.net/th?id=OIP.8bWjgbrHBHiNkMNMI9WSHwHaE8&pid=Api&P=0&w=241&h=162");
        tempItemNameB.add("Sundar Pichai");
        tempItemDesignationB.add("Millionaire");



        mTeamItemImageUrl.add(tempItemImageUrlB);
        mTeamItemName.add(tempItemNameB);
        mTeamItemDesignation.add(tempItemDesignationB);

        //        Dummy c
        ArrayList<String> tempItemImageUrlc = new ArrayList<>();
        ArrayList<String> tempItemNamec = new ArrayList<>();
        ArrayList<String> tempItemDesignationc = new ArrayList<>();

//        Dummy 1
        mTeamHeader.add("Android Team 2");



//        item 1
        tempItemImageUrlc.add("https://yt3.ggpht.com/a-/AAuE7mD8j66Gv5r4oLf48Ij7PMljbIm_-GrASQ-CSA=s900-mo-c-c0xffffffff-rj-k-no");
        tempItemNamec.add("Bill Gates");
        tempItemDesignationc.add("Bigger Billionaire");

//        item2
        tempItemImageUrlc.add("https://tse3.mm.bing.net/th?id=OIP.6jjiDq38UkZtWSRJp6NMJwHaJb&pid=Api&P=0&w=300&h=300");
        tempItemNamec.add("Steve Jobs");
        tempItemDesignationc.add("Billionaire");



        mTeamItemImageUrl.add(tempItemImageUrlc);
        mTeamItemName.add(tempItemNamec);
        mTeamItemDesignation.add(tempItemDesignationc);

//        Dummy d
        ArrayList<String> tempItemImageUrld = new ArrayList<>();
        ArrayList<String> tempItemNamed = new ArrayList<>();
        ArrayList<String> tempItemDesignationd = new ArrayList<>();

//        Dummy 1
        mTeamHeader.add("Web Team 2");



//        item 1
        tempItemImageUrld.add("https://tse3.mm.bing.net/th?id=OIP.CXJxyvRQ1fIHlf984SGv0AHaFj&pid=Api&P=0&w=225&h=170");
        tempItemNamed.add("Mark Zuckerberg");
        tempItemDesignationd.add("Bigger Billionaire");

//        item2
        tempItemImageUrld.add("https://tse2.mm.bing.net/th?id=OIP.8bWjgbrHBHiNkMNMI9WSHwHaE8&pid=Api&P=0&w=241&h=162");
        tempItemNamed.add("Sundar Pichai");
        tempItemDesignationd.add("Millionaire");



        mTeamItemImageUrl.add(tempItemImageUrld);
        mTeamItemName.add(tempItemNamed);
        mTeamItemDesignation.add(tempItemDesignationd);



        teamRecyclerView();

    }

    private void teamRecyclerView(){
        TeamAdapter adapter = new TeamAdapter(getActivity(),mTeamHeader,mTeamItemImageUrl,mTeamItemName,mTeamItemDesignation);
        teamRecyclerView.setAdapter(adapter);
        teamRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
