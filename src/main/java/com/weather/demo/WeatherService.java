package com.weather.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    RestTemplate restTemplate;


    WeatherData getWeatherDataFromAPI(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com");
        httpHeaders.add("x-rapidapi-key", "80db2ddb30msh3e93e55caf2e2c3p127bfcjsn7961a0c318eb");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<WeatherData> weatherLondon = restTemplate.exchange("https://community-open-weather-map.p.rapidapi.com/weather?callback=test&id=2172797&units=%2522metric%2522%20or%20%2522imperial%2522&mode=xml%252C%20html&q=London%252Cuk", HttpMethod.GET, httpEntity, WeatherData.class);
        return weatherLondon.getBody();
    }
}
