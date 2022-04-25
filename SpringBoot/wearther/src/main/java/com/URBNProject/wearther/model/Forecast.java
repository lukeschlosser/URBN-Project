package com.URBNProject.wearther.model;

public class Forecast {

    private String key;
    private String weatherText;
    private String temperatureF;
    private String temperatureC;
    private boolean hasPrecipitation;
    private String link;

    public Forecast(){}

    public Forecast(String key, String weatherText, String temperatureF, String temperatureC, boolean hasPrecipitation, String link) {
        this.key = key;
        this.weatherText = weatherText;
        this.temperatureF = temperatureF;
        this.temperatureC = temperatureC;
        this.hasPrecipitation = hasPrecipitation;
        this.link = link;
    }

    public String getKey() {
        return key;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public String getTemperatureF() {
        return temperatureF;
    }

    public String getTemperatureC() {
        return temperatureC;
    }

    public boolean isHasPrecipitation() {
        return hasPrecipitation;
    }

    public String getLink() {
        return link;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public void setTemperatureF(String temperatureF) {
        this.temperatureF = temperatureF;
    }

    public void setTemperatureC(String temperatureC) {
        this.temperatureC = temperatureC;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String toString() {
        return "Forecast{" + key +
                "key=" + key +
                "conditions=" + weatherText +
                "temperatureF=" + temperatureF +
                "temperatureC=" + temperatureC +
                "hasPrecipitation=" + hasPrecipitation +
                "link=" + link +
                "}";
    }
}
