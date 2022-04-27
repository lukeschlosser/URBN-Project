package com.URBNProject.wearther.controller;

import com.URBNProject.wearther.model.Forecast;
import com.URBNProject.wearther.services.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WeatherController {

    private static final String API_BASE_URL = "http://dataservice.accuweather.com";

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    // get 'Current Weather Conditions' for the given postal code
    @RequestMapping(path = "/weather/{postalCode}", method = RequestMethod.GET)
    public Forecast getWeatherByPostalCode(@PathVariable String postalCode) {
        return weatherService.getWeatherByPostalCode(postalCode);
    }

}
