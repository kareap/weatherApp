package com.weather.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData {

    @JsonProperty("body")
    private Value getWeatherData;
}
