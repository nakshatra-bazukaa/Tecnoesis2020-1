package com.github.tenx.tecnoesis20.data.models;

import com.google.firebase.database.PropertyName;

import java.util.List;

public class LocationDetailBody {

    @PropertyName("lat")
    String lat;

    @PropertyName("lng")
    String lng;

    @PropertyName("name")
    String name;

    @PropertyName("image")
    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @PropertyName("HomeEventBody")
    List<MarkerEvent> events;

    public LocationDetailBody() {
    }

    public LocationDetailBody(String lat, String lng, String name) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
    }

    public LocationDetailBody(String lat, String lng, String name, List<MarkerEvent> events) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.events = events;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MarkerEvent> getEvents() {
        return events;
    }

    public void setEvents(List<MarkerEvent> events) {
        this.events = events;
    }

    public static class MarkerEvent {

        @PropertyName("name")
        String name;

        @PropertyName("date")
        String date;

        @PropertyName("location")
        String location;

        @PropertyName("image")
        String image;

        public MarkerEvent() {
        }

        public MarkerEvent(String name, String date, String location, String image) {
            this.name = name;
            this.date = date;
            this.location = location;
            this.image = image;
        }



        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

}
