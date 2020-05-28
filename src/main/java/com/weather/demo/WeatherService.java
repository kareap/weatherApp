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

    Weather getWeatherDescriptionFromAPI(String city) {
        ResponseEntity<JsonNode> json = getJsonNodeResponseEntity(city);
        JsonNode jsonNodeWeather = json.getBody().at("/list/0/weather/0");

        Weather weather = new Weather();
        weather.setMain(jsonNodeWeather.get("main").textValue());
        weather.setDescription(jsonNodeWeather.get("description").textValue());

        return weather;
    }

    Weather getTemperatureFromAPI(String city) {
        ResponseEntity<JsonNode> json = getJsonNodeResponseEntity(city);
        JsonNode jsonNodeTemp = json.getBody().at("/list/0/main");

        Weather weather = new Weather();
        weather.setTemp(jsonNodeTemp.get("temp").intValue());

        return weather;
    }

    Weather getCountFromAPI(String city) { //does city exist?
        ResponseEntity<JsonNode> json = getJsonNodeResponseEntity(city);

        Weather weather = new Weather();
        weather.setCount(json.getBody().get("count").intValue());
        return weather;
    }

    private ResponseEntity<JsonNode> getJsonNodeResponseEntity(String city) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com");
        httpHeaders.add("x-rapidapi-key", "80db2ddb30msh3e93e55caf2e2c3p127bfcjsn7961a0c318eb");
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        return restTemplate.exchange("https://community-open-weather-map.p.rapidapi.com/find?type=link%252C%20accurate&units=imperial%252C%20metric&q=" + city, HttpMethod.GET, httpEntity, JsonNode.class);
    }
}
