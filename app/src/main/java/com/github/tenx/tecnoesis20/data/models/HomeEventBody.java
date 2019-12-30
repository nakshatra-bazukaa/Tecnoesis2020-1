package com.github.tenx.tecnoesis20.data.models;

import com.google.firebase.database.PropertyName;

public class HomeEventBody {


    @PropertyName("name")
    private String name;

    @PropertyName("description")
    private String description;

    @PropertyName("image")
    private String  image;

    @PropertyName("website")
    private String website;


    public HomeEventBody() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
