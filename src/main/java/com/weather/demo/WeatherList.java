package com.weather.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class WeatherList {

    @JsonProperty("list")
    private List<Value> weatherList;

    public WeatherList() {
        weatherList = new ArrayList<>();
    }

    public List<Value> getWeatherList() {
        return weatherList;
    }

}
