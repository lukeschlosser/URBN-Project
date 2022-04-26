<template>
    <div id="search">
        <input id="searchBar" type="text" v-model="search" placeholder="Search" />
        <button v-on:click="searchWeather()">What's the Wearther?</button>
    </div>
    <div id="parentDiv">
        <div id="displayWeather"></div>
    </div>
</template>

<script>
import WeatherService from "@/services/WeatherService.js"

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
    }
}

</script>

<style>

</style>
