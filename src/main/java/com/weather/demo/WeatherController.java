package com.weather.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.print.attribute.standard.PresentationDirection;

@Controller
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/breeze")
    String chooseCity(Model model) {
        String city = null;
        model.addAttribute("city", city);
        return "start";
    }

    @PostMapping("/post-city/")
    String postCity(@ModelAttribute String city) {
        weatherService.getCityNameFromApi(city);
        return city;
    }

    @GetMapping("/weather/{city}")
    String getWeatherByCity(@PathVariable String city) {
        return weatherService.getWeatherDataFromAPI(city).toString();
    }


}
