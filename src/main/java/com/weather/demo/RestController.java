package com.weather.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    WeatherService weatherService;
/*
    @GetMapping("/weather/{city}")
    String getWeatherJSON(@PathVariable String city) {
        return weatherService.getWeatherDataFromAPI(city).toString();
    }*/

}
