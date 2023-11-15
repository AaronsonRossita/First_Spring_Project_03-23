package com.First_Spring_Project_0323.tvMaze;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TvMazeModel {

    private Integer id;
    private String name;
    @JsonProperty("url")
    private String imageUrl;

    public TvMazeModel(Integer id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}


