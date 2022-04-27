package com.URBNProject.wearther.services;

import com.URBNProject.wearther.model.Forecast;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@Component
public class WeatherService {

    private static final String API_BASE_URL = "http://dataservice.accuweather.com";
    private static final String API_KEY = "?apikey=ycWGVPxLK73Vg9GhLGeLQnjHaRxX5vBX";
    private String searchByPostal = "/locations/v1/postalcodes/search?apikey=ycWGVPxLK73Vg9GhLGeLQnjHaRxX5vBX&q=";
    private String searchByKey = "/currentconditions/v1/";
    private RestTemplate restTemplate = new RestTemplate();

    // FULL GET URL for current conditions http://dataservice.accuweather.com/currentconditions/v1/{key goes here}?apikey=ycWGVPxLK73Vg9GhLGeLQnjHaRxX5vBX

    public WeatherService(){}

    private HttpEntity<Void> makeHeaders(){
        HttpHeaders headers = new HttpHeaders();
        return new HttpEntity<>(headers);
    }
    // main method for getting forecast details from a given postal code
    public Forecast getWeatherByPostalCode(String postalCode) {
        Forecast forecast = new Forecast();
        String key = fetchKeyFromPostalCode(postalCode);
        key = key.replace("\"","");
        String forecastJsonString = null;

        try {

            String path = API_BASE_URL + searchByKey + key + API_KEY;

            ResponseEntity<String> response = restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), String.class);
            forecastJsonString = response.getBody();

        } catch(RestClientResponseException | ResourceAccessException e){
            System.out.println(e.getMessage());
        }

        List<String> forecastJson = extractWeatherInformation(forecastJsonString);
        forecast.setWeatherText(forecastJson.get(0));
        forecast.setTemperatureC(forecastJson.get(1));
        forecast.setTemperatureF(forecastJson.get(2));
        forecast.setHasPrecipitation(forecastJson.get(3).equalsIgnoreCase("true"));
        forecast.setLink(forecastJson.get(4));

        return forecast;
    }

    // retrieve a key from given valid postal code
    public String fetchKeyFromPostalCode(String postalCode){
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
    // further fetching of the key -- Broken into a separate method in case future versions need different search params
    public String fetchKeyFromJsonString(String key, String jsonString, Integer offset) {
        int indexOfKey = jsonString.indexOf(key);
        int beginIndexOfValue = indexOfKey + key.length() + offset;
        String[] split = jsonString.substring(beginIndexOfValue).split(",");
        String isolatedKey = split[0];
        return isolatedKey;
    }
    // extracting the pertinent information from the API call
    public List<String> extractWeatherInformation(String forecastJsonString){

        List<String> listOfForecastInfo = new ArrayList<>();

        String weatherText = fetchForecastDetails("WeatherText", forecastJsonString, 3);
        weatherText = StringUtils.chop(weatherText);
        listOfForecastInfo.add(weatherText);

        String temperatureC = fetchForecastDetails("\"Value\"", forecastJsonString, 1);
        listOfForecastInfo.add(temperatureC);

        String temperatureF = fetchForecastDetails("\"Imperial\":{\"Value\"", forecastJsonString, 1);
        listOfForecastInfo.add(temperatureF);

        String hasPrecipitation = fetchForecastDetails("\"HasPrecipitation\"", forecastJsonString, 1);
        listOfForecastInfo.add(hasPrecipitation);

        String link = fetchForecastDetails("\"Link\"", forecastJsonString, 1);
        link = StringUtils.chop(link);
        link = StringUtils.chop(link);
        link = link.replace("\"","");
        listOfForecastInfo.add(link);

        return listOfForecastInfo;
    }
    // extracting from the API call further
    public String fetchForecastDetails(String pathKey, String forecastJsonString, Integer offset){

        int indexOfPathKey = forecastJsonString.indexOf(pathKey);
        int indexStart = indexOfPathKey + pathKey.length() + offset;

        String[] split = forecastJsonString.substring(indexStart).split(",");
        String isolatedPath = split[0];

        return isolatedPath;
    }
}
