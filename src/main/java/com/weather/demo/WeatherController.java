package com.weather.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/")
    String chooseCity() {
        return "start";
    }

    @PostMapping("/")
    String postCity(Model model, @RequestParam String city) {
        Weather weather = weatherService.getWeatherDataFromAPI(city);
        weather.setCount(weatherService.checkCityAPI(city));
        model.addAttribute("count", weather.getCount());
        model.addAttribute("weather", weather);
        model.addAttribute("city", city);
        return "weather";
    }



}
