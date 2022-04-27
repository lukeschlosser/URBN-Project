// Suggestions on what to wear based on the forecast
<template>
    <div id="WhatToWearPage">
        <div class="whatToWear">
            <ul class="whatToWearList">
                <li class="top">URBAN Top Picks {{ topWear }}</li>
                <li class="bottom">URBAN Bottom Picks {{ bottomWear }}</li>
            </ul>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {}
    },
    methods:{
        topWear(){
            if($store.state.temperatureF > 85){
                return $store.state.veryHotTop;
                    } else if($store.state.temperatureF > 70){
                        return $store.state.hotTop;
                    } else if($store.state.temperatureF > 50){
                        return $store.state.mildTop;
                    } else {
                        return $store.state.coldTop;
                    }
        },
        bottomWear(){
            if($store.state.temperatureF > 80){
                return $store.state.hotBottom
            } else { return $store.state.coldBottom; }

        }
    },
    computed:{
        
    }
}


</script>
