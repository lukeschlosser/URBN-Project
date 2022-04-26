
import axios from 'axios'

const http=axios.create({
    baseURL:"http://localhost:8080"
});

class WeatherService{
    getWeatherByPostalCode(postalCode){
        return http.get(`/weather/${postalCode}`);
    }
}

export default new WeatherService()