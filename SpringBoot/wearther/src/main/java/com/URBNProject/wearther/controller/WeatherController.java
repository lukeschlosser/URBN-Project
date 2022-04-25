package com.URBNProject.wearther.controller;

import com.URBNProject.wearther.model.Forecast;
import com.URBNProject.wearther.services.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class WeatherController {

    String API_BASE_URL = "http://dataservice.accuweather.com";

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @RequestMapping(path = "/weather/{postalCode}", method = RequestMethod.GET)
    public List<Forecast> getWeatherByPostalCode(@PathVariable String postalCode) {
        return weatherService.getWeatherByPostalCode(postalCode);
    }


}
