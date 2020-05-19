package com.weather.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather")
    String getWeatherJSON() {
        String name = weatherService.getWeatherDataFromAPI().getWeatherList().get(0).getName();
        return name;
    }
}
