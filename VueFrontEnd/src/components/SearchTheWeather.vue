<template>
    <div id="searchPage">


    <div class="search">
        <input class="searchBar" type="text" v-model="search" placeholder="Enter Postal Code"/>    
        <button class="searchButton" href="#" v-on:click="searchWeather"><i class="material-icons">search</i></button>
    </div>    
        <div id="tableDiv">
        <table class="weatherTable">
            <thead>
                <th> Conditions </th>
                <th> Temperature in C </th>
                <th> Temperature in F </th>
                <th> Rain? </th>
                <th> More Details </th>
            </thead>
            <tbody>
                <tr v-for="forecast in forecasts" v-bind:key="forecast">
                    <td> {{forecast.weatherText}} </td>
                    <td> {{forecast.temperatureC}} </td>
                    <td> {{forecast.temperatureF}} </td>
                    <td> {{forecast.hasPrecipitation}} </td>
                    <td> {{forecast.link}} </td>
                </tr>
            </tbody>
        </table>
        </div>
        
        
    
</div>  
</template>

<script>
import WeatherService from '@/services/WeatherService'

    export default {
    
    data() {
        return {
            searchResults: [],
            search: "",
        }
    },
    methods:{
        searchWeather(){
            WeatherService.getWeatherByPostalCode(this.search).then(response=>{
                this.$store.commit("SET_FORECAST", response.data)
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
        }
    },
    computed: {
        forecastDetails(){
            return this.$store.state.activeWeather;
        }
    },    
        created() {
            this.getWeatherByPostalCode()
        }
    
}

</script>

<style>

div#searchPage{
    display: grid;
    grid-template-columns: 1fr, 1fr, 1fr, 1fr, 1fr;
    grid-template-rows: auto, 1fr, 50px;
    grid-template-areas: 
        "search search search search search"
        "tableDiv" "tableDiv" "tableDiv" "tableDiv" "tableDiv";
}

.search {
    position: absolute;
    top: 17%;
    left: 50%;
    transform:  translate(-50%,50%);
    background: #2c3e50;
    height: 40px;
    border-radius: 40px;
    padding: 10px;

}

.search:hover > .searchBar {
    width: 240px;
    padding: 0 6px;
}

.search:hover > .searchButton {
  background: white;
  color : #2c3e50;
}

.searchButton {
    color: white;
    float: right;
    width: 40px;
    height: 40px;
    border-radius: 50%;
    background: #2c3e50;
    display: flex;
    justify-content: center;
    align-items: center;
    transition: 0.4s;
}

.searchBar {
    border:none;
    background: none;
    outline:none;
    float:left;
    padding: 0;
    color: white;
    font-size: 16px;
    transition: 0.4s;
    line-height: 40px;
    width: 0px;

}

div#tableDiv{
    grid-area: auto;   
}

@media screen and (max-height: 700px) and (min-width: 400px) {
  
  #searchPage{
    grid-template-areas:
    "search"
    "tableDiv";
    grid-template-columns: 1fr;
    overflow: scroll;
  }
  div#tableDiv{
  grid-area: auto;
  display: flex;
  flex-direction: row;
  flex-flow: row wrap;
  justify-content: space-evenly;
  height: 60vh;
}
}

@media screen and (max-width: 620px) {
.search:hover > .searchBar {
    width: 150px;
    padding: 0 6px;
}
}

</style>