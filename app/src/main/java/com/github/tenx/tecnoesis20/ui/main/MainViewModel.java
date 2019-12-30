package com.github.tenx.tecnoesis20.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.github.tenx.tecnoesis20.data.models.LocationDetailBody;
import com.github.tenx.tecnoesis20.data.models.ModuleBody;
import com.github.tenx.tecnoesis20.ui.MyApplication;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import timber.log.Timber;

public class MainViewModel  extends AndroidViewModel {



    private MutableLiveData<List<ModuleBody>> ldModulesList;

    private MutableLiveData<List<LocationDetailBody>> ldLocationDetailsList;
    private MutableLiveData<Boolean> isLocationsLoaded;

    private MutableLiveData<Boolean> isModulesLoaded;
    private MyApplication app;
    private FirebaseDatabase db;


    public MainViewModel(@NonNull Application application)
    {
        super(application);
        app  = (MyApplication) application;
        db = FirebaseDatabase.getInstance();
        ldModulesList = new MutableLiveData<>();
        isModulesLoaded = new MutableLiveData<>();
        ldLocationDetailsList = new MutableLiveData<>();
        isLocationsLoaded = new MutableLiveData<>();
    }



    public LiveData<List<ModuleBody>> getModules(){
        return ldModulesList;
    }

    public LiveData<List<LocationDetailBody>> getLdLocationDetailsList() {
        return ldLocationDetailsList;
    }

    public LiveData<Boolean> getIsLocationsLoaded() {
        return isLocationsLoaded;
    }

    public MutableLiveData<Boolean> getIsModulesLoaded() {
        return isModulesLoaded;
    }

    public void loadModules(){
        isModulesLoaded.postValue(false);
            db.getReference().child("modules").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    isModulesLoaded.postValue(true);
                    Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();
                    List<ModuleBody> temp = new ArrayList<>();
                    while (iterator.hasNext()){

                        DataSnapshot snap = iterator.next();

                        ModuleBody data = snap.getValue(ModuleBody.class);
                        Timber.d("events : "+data.getEvents().size());


                        temp.add(data);

                        if(data.getEvents() != null){
                            Timber.d("Events size : "+ data.getEvents().size());
                        }else {
                            Timber.d("Events is empty!");
                        }
                    }

//store data at application level
                    app.setModuleList(temp);

//                    post update to activity
                    ldModulesList.postValue(temp);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                        isModulesLoaded.postValue(true);
                }
            });
    }

    public void loadLocationDetails(){
        isLocationsLoaded.postValue(false);
        db.getReference().child("locations").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                isModulesLoaded.postValue(true);
                Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();
                List<LocationDetailBody> temp = new ArrayList<>();
                while (iterator.hasNext()){

                    DataSnapshot snap = iterator.next();

                    LocationDetailBody data = snap.getValue(LocationDetailBody.class);
                    temp.add(data);
                }

//                    post update to activity
                ldLocationDetailsList.postValue(temp);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                isLocationsLoaded.postValue(true);
            }
        });
    }







}
