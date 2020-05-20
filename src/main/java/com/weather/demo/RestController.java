package com.weather.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    WeatherService weatherService;

  /*  @GetMapping("/weather")
    String getWeatherJSON() {
        String name = getValue().getName();
        String main = getWeather().getMain();
        String description = getWeather().getDescription();
        String icon = getWeather().getIcon();
        return name + "\n" + main +"\n" + description + "\n" + icon;
    }

    private Weather getWeather() {
        return getValue().getWeather().get(0);
    }

    private Value getValue() {
        return weatherService.getWeatherDataFromAPI().getWeatherList().get(0);
    }*/

    @GetMapping("/weather")
    String getWeatherJSON() {
        return weatherService.getWeatherDataFromAPI().toString();
    }



}
