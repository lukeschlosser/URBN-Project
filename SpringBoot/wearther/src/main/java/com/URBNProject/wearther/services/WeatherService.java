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

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@Component
public class WeatherService {

    private RestTemplate restTemplate = new RestTemplate();

    private String API_BASE_URL = "http://dataservice.accuweather.com";
    private String searchByPostal = "/locations/v1/postalcodes/search?apikey=ycWGVPxLK73Vg9GhLGeLQnjHaRxX5vBX&q=";
    private String searchByKey = "/currentconditions/v1/";
    private String API_KEY = "?apikey=ycWGVPxLK73Vg9GhLGeLQnjHaRxX5vBX";

    // FULL GET URL for current conditions http://dataservice.accuweather.com/currentconditions/v1/{key goes here}?apikey=ycWGVPxLK73Vg9GhLGeLQnjHaRxX5vBX

    public WeatherService(){}

    public WeatherService(String API_BASE_URL){
        this.API_BASE_URL = API_BASE_URL;
    }

    private HttpEntity<Void> makeHeaders(){
        HttpHeaders headers = new HttpHeaders();
        return new HttpEntity<>(headers);
    }

    public List<Forecast> getWeatherByPostalCode(String postalCode) {
        List<Forecast> forecastList = new ArrayList<>();
        String key = fetchKeyFromPostalCode(postalCode);
        String forecastJsonString = null;

        try {

            String path = API_BASE_URL + searchByKey + key + API_KEY;

            ResponseEntity<String> response = restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), String.class);
            forecastJsonString = response.getBody();

        } catch(RestClientResponseException | ResourceAccessException e){
            System.out.println(e.getMessage());
        }

        return forecastJsonString(forecastJsonString, forecastList);
    }

    //retrieve a key from given valid postal code
    //TODO test in postman once controller setup
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

    public String fetchKeyFromJsonString(String key, String jsonString, Integer offset) {
        int indexOfKey = jsonString.indexOf(key);
        int beginIndexOfValue = indexOfKey + key.length() + offset;
        String[] split = jsonString.substring(beginIndexOfValue).split(",");
        String isolatedKey = split[1];
        return isolatedKey;
    }

    public String fetchForecastDetails(String pathKey, String forecastJsonString, Integer offset){

        int indexOfPathKey = forecastJsonString.indexOf(pathKey);
        int indexStart = indexOfPathKey + pathKey.length() + offset;

        String[] split = forecastJsonString.substring(indexStart).split("\"");
        String isolatedPath = split[0];

        return isolatedPath;
    }

    public List<String> extractWeatherInformation(String forecastJsonString){

        List<String> listOfForecastInfo = new ArrayList<>();

        String key = fetchKeyFromJsonString("\"Key\"", forecastJsonString, 1);
        listOfForecastInfo.add(key);

        String weatherText = fetchForecastDetails("\"WeatherText\"", forecastJsonString, 1);
        listOfForecastInfo.add(weatherText);

        String temperatureC = fetchForecastDetails("\"Value\"", forecastJsonString, 1);
        listOfForecastInfo.add(temperatureC);
        //TODO figure out if going to convert or grab the second "Value"
        String temperatureF = fetchForecastDetails("\"Value\"", forecastJsonString, 1);
        listOfForecastInfo.add(temperatureF);

        String hasPrecipitation = fetchForecastDetails("\"HasPrecipitation\"", forecastJsonString, 1);
        listOfForecastInfo.add(hasPrecipitation);

        String link = fetchForecastDetails("\"Link\"", forecastJsonString, 1);
        listOfForecastInfo.add(link);

        return listOfForecastInfo;
    }

    public List<Forecast> forecastJsonString(String listForecastJsonString, List<Forecast> listForecast){

        while(listForecastJsonString.contains("\"LocalObservationDateTime\"")){
            Forecast forecast = new Forecast();
            List<String> listOfForecast = new ArrayList<>();

            listOfForecast = extractWeatherInformation(listForecastJsonString);

            forecast.setKey(listOfForecast.get(0));
            forecast.setWeatherText(listOfForecast.get(1));
            forecast.setTemperatureC(listOfForecast.get(2));
            forecast.setTemperatureF(listOfForecast.get(3));
            forecast.setHasPrecipitation(listOfForecast.get(4).equalsIgnoreCase("true"));
            forecast.setLink(listOfForecast.get(5));

            listForecast.add(forecast);
        }

        return listForecast;
    }

}
