<template>
    <div class="search">
        <input id="searchBar" type="text" v-model="search" placeholder="Search"/>    
        <button v-on:click="searchWeather()">Search By Postal Code</button>

        <table class="weatherTable">
            <thead>
                <th> Conditions </th>
                <th> Temperature in C </th>
                <th> Temperature in F </th>
                <th> Rain? </th>
                <th> More Details </th>
            </thead>
            <tbody>
                <tr v-for = "forecast in forecasts" v-bind:key = "forecast">
                    <td> {{forecast.weatherText}} </td>
                    <td> {{forecast.temperatureC}} </td>
                    <td> {{forecast.temperatureF}} </td>
                    <td> {{forecast.hasPrecipitation}} </td>
                    <td> {{forecast.link}} </td>
                </tr>
            </tbody>
        </table>
    
    
    </div>  
</template>

<script>
import WeatherService from '../services/WeatherService'

    export default {
        components: {},
    data() {
        return {

            searchResults: [],
            search: "",
        }
    },
    methods:{
        searchWeather(){
            WeatherService.getWeatherByPostalCode(this.search).then(response=>{
                this.$store.commite("SET_WEATHER", response.data)
                console.log(response.data);
            }).catch(function (error) {
                if (error.response) {
                    //Request made and server responded
                    console.log("Response Error");
                    console.log(error.response.data);
                } else if (error.request) {
                    //Request was made but no response was recieved
                    console.log("Request Error");
                    console.log(error.request);
                } else {
                    //Something happening in setting up the request that triggered an error
                    console.log("Misc Error");
                    console.log('Error', error.message);
                }
            });
        },
        created() {
            this.getWeatherByPostalCode()
        }
    }
    }

</script>

<style>

</style>
