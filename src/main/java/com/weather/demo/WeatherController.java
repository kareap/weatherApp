package com.weather.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/breeze")
    String showWeatherData(){
        return "weather";
    }
}
