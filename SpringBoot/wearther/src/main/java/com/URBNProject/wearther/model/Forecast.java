package com.URBNProject.wearther.model;

public class Forecast {

    private String weatherText;
    private String temperatureF;
    private String temperatureC;
    private boolean hasPrecipitation;
    private String link;

    public Forecast(){}

    public Forecast(String weatherText, String temperatureF, String temperatureC, boolean hasPrecipitation, String link) {
        this.weatherText = weatherText;
        this.temperatureC = temperatureC;
        this.temperatureF = temperatureF;
        this.hasPrecipitation = hasPrecipitation;
        this.link = link;
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
        return "Forecast{" +
                "conditions=" + weatherText +
                "temperatureF=" + temperatureF +
                "temperatureC=" + temperatureC +
                "hasPrecipitation=" + hasPrecipitation +
                "link=" + link +
                "}";
    }
}
