<template>
    <div id="WhatToWearPage">
        <div class="whatToWear">
            
                <p class="top">URBAN Top Picks <a>{{topWear}}</a> </p>
                
                <p class="bottom" >URBAN Bottom Picks {{ bottomWear }}</p>
            
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
            if(this.$store.state.forecast.temperatureF > 85){
                return this.$store.state.veryHotTop;
                    } else if(this.$store.state.forecast.temperatureF > 70){
                        return this.$store.state.hotTop;
                    } else if(this.$store.state.forecast.temperatureF > 50){
                        return this.$store.state.mildTop;
                    } else {
                        return this.$store.state.coldTop;
                    }
        },
        bottomWear(){
            if(this.$store.state.forecast.temperatureF > 80){
                return this.$store.state.hotBottom
            } else { return this.$store.state.coldBottom; }

        }
    }
}

</script>
