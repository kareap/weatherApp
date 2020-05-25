package com.weather.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/breeze")
    String chooseCity() {
        return "start";
    }

    @PostMapping("/breeze")
    String postCity(Model model, @RequestParam String city) {

        int count = weatherService.checkCityAPI(city);
        model.addAttribute("count", count);
        model.addAttribute("city", city);
        return city;
    }

    @GetMapping("/weather/{city}")
    String getWeatherByCity(Model model, @PathVariable String city) {
        Weather weather = weatherService.getWeatherDataFromAPI(city);

        model.addAttribute("city", city);
        model.addAttribute("weather", weather);
        return "weather";
    }


}
