package com.github.tenx.tecnoesis20.ui.main.schedule;

import androidx.lifecycle.ViewModel;

import com.github.tenx.tecnoesis20.data.models.MarkerDetailBody;

import java.util.ArrayList;
import java.util.List;


public class ScheduleViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private List<MarkerDetailBody> markerDetaiList;


    public ScheduleViewModel() {
        markerDetaiList = new ArrayList<>();
    }


    public  List<MarkerDetailBody> getMarkerDetails(){

        List<MarkerDetailBody.MarkerEvent> tem = new ArrayList<>();
        tem.add(new MarkerDetailBody.MarkerEvent("event 1", "12 oct", "", ""));
        tem.add(new MarkerDetailBody.MarkerEvent("event 2", "13 oct", "", ""));
        tem.add(new MarkerDetailBody.MarkerEvent("event 3", "14 oct", "", ""));
        tem.add(new MarkerDetailBody.MarkerEvent("event 4", "15 oct", "", ""));


        markerDetaiList.add(new MarkerDetailBody("24.7557", "92.7832" , "Sports Complex"  , tem));
        markerDetaiList.add(new MarkerDetailBody("24.7582", "92.7902" , "New Gallery" , tem));
        markerDetaiList.add(new MarkerDetailBody("24.757309", "92.788820" , "Central Library", tem));


       return markerDetaiList;
    }
}


