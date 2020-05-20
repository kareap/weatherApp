package com.weather.demo;

import com.fasterxml.jackson.databind.JsonNode;
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

    Weather getWeatherDataFromAPI(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com");
        httpHeaders.add("x-rapidapi-key", "80db2ddb30msh3e93e55caf2e2c3p127bfcjsn7961a0c318eb");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        ResponseEntity<JsonNode> json = restTemplate.exchange("https://community-open-weather-map.p.rapidapi.com/find?type=link%252C%20accurate&units=imperial%252C%20metric&q=london", HttpMethod.GET, httpEntity, JsonNode.class);
        JsonNode jsonNode = json.getBody().at("/list/0/weather/0");
        Weather weather = new Weather();
        weather.setMain(jsonNode.get("main").textValue());
        return weather;
    }
}
