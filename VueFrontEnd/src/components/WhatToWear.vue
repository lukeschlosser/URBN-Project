<template>
    <div id="WhatToWearPage">
        <div class="whatToWear" >
            <!-- <h3>See What Urban Outfitters has to offer for your current weather conditions? </h3>
            <button>Show me!</button> -->
            
                <a class="topLink" :href="topWear" target="_blank" v-if="topWear!=0" >URBAN Top Picks</a>
                <a class="bottomLink" :href="bottomWear" target="_blank" v-if="bottomWear!=0">URBAN Bottom Picks</a>
            
        </div>
    </div>
</template>

<script>

export default {
    data() {
        return {}
    },
    methods:{},
    computed:{
        topWear(){
            if(this.$store.state.forecast.temperatureF > 80){
                return this.$store.state.veryHotTop;
                    } else if(this.$store.state.forecast.temperatureF > 70){
                        return this.$store.state.hotTop;
                    } else if(this.$store.state.forecast.temperatureF > 50){
                        return this.$store.state.mildTop;
                    } else if(this.$store.state.forecast.temperatureF > 0){
                        return this.$store.state.coldTop;
                    } else {
                        return 0;
                    }
        },
        bottomWear(){
            if(this.$store.state.forecast.temperatureF > 80){
                return this.$store.state.hotBottom
            } else if(this.$store.state.forecast.temperatureF > 0){ 
                return this.$store.state.coldBottom; 
            } else {
                return 0;
            }

        }
    }
}

</script>

<style>
#whatToWearPage{
    display: grid;
}

.whatToWear{
    display: grid;
    justify-content: center;
    align-items: center;
    margin-bottom: 100%;
}

a {
  color:#2c3e50;
  padding: 15px;
  text-decoration: none;
}

a:active {
  background-color:#2c3e50;
  color: black;
}

a:hover:not(active) {
  background-color: #2c3e50;
  color: whitesmoke;
}



</style>
