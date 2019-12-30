package com.github.tenx.tecnoesis20.data.rest.events;

import com.github.tenx.tecnoesis20.data.models.EventResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface EventsApiService {
    @GET("/api/v1/HomeEventBody")
    Call<ArrayList<EventResponse>> getEvents();
}
