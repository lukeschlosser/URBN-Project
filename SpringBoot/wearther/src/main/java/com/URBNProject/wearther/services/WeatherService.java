package com.URBNProject.wearther.services;

import com.URBNProject.wearther.model.Forecast;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class WeatherService {

    private RestTemplate restTemplate = new RestTemplate();

    private String API_BASE_URL = "http://dataservice.accuweather.com";
    private String searchByPostal = "/locations/v1/postalcodes/search?apikey=ycWGVPxLK73Vg9GhLGeLQnjHaRxX5vBX&q=";
    private String searchByKey = "/currentconditions/v1/";
    private String API_KEY = "?apikey=ycWGVPxLK73Vg9GhLGeLQnjHaRxX5vBX";

    // FULL GET URL for currentconditions http://dataservice.accuweather.com/currentconditions/v1/{key goes here}?apikey=ycWGVPxLK73Vg9GhLGeLQnjHaRxX5vBX

    public WeatherService(){}

    public WeatherService(String API_BASE_URL){
        this.API_BASE_URL = API_BASE_URL;
    }

    private HttpEntity<Void> makeHeaders(){
        HttpHeaders headers = new HttpHeaders();
        return new HttpEntity<>(headers);
    }

    public Forecast getWeatherByPostalCode(String postalCode) {
        return null;
    }

    //retrieve a key from given valid postal code
    //TODO test in postman once controller setup
    public String fetchKeyFromPostalCode(int postalCode){
        String jsonString = null;
        String key = "";

        try {

            String path = API_BASE_URL + searchByPostal + postalCode;
            ResponseEntity<String> response =
                    restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), String.class);
            jsonString = response.getBody();

        } catch (RestClientResponseException | ResourceAccessException e){
            System.out.println(e.getMessage());
        }

        key = fetchKeyFromJsonString("\"Key\"", jsonString, 1);

        return key;
    }

    public String fetchKeyFromJsonString(String key, String jsonString, Integer offset) {
        int indexOfKey = jsonString.indexOf(key);
        int beginIndexOfValue = indexOfKey + key.length() + offset;
        String[] split = jsonString.substring(beginIndexOfValue).split(",");
        String isolatedKey = split[0];
        return isolatedKey;
    }

}
