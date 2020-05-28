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
        int count = weatherService.getCountFromAPI(city).getCount();
        if(count == 0) {
            String errorMessage = "Whoops, there is no weather-data available for the city. Try another city...";
            model.addAttribute("errorMessage", errorMessage);
        }

        Weather weather = weatherService.getWeatherDescriptionFromAPI(city);
        model.addAttribute("weather", weather);
        model.addAttribute("city", city);

        int temp = weatherService.getTemperatureFromAPI(city).getTemp();
        model.addAttribute("temp", temp);



        return "weather";
    }


}
