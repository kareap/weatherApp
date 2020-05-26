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
        Weather weather = weatherService.getWeatherDescriptionFromAPI(city);
        model.addAttribute("weather", weather);
        model.addAttribute("city", city);

        int temp = weatherService.getTemperatureFromAPI(city).getTemp();
        model.addAttribute("temp", temp);

        /*int count = weatherService.getCountFromAPI(city).getCount();
        model.addAttribute("count", count);*/

        return "weather";
    }


}
