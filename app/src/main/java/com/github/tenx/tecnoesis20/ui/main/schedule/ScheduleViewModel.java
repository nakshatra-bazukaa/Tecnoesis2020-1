package com.github.tenx.tecnoesis20.ui.main.schedule;

import androidx.lifecycle.ViewModel;

import com.github.tenx.tecnoesis20.data.models.LocationDetailBody;

import java.util.ArrayList;
import java.util.List;


public class ScheduleViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private List<LocationDetailBody> markerDetaiList;


    public ScheduleViewModel() {
        markerDetaiList = new ArrayList<>();
    }

}


