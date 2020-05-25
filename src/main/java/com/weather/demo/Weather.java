package com.weather.demo;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Weather {

    private String main;
    private String description;
    private String count;


    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "main='" + main + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
