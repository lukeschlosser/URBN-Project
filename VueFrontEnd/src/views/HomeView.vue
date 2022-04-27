<template>
  <div class="home">
    <div id="searchComponent">
    <SearchTheWeather/>
    <WhatToWear/>
    <div id="whatToWearComponent">
    
    </div>
    </div>
  </div>
</template>

<script>
import SearchTheWeather from '@/components/SearchTheWeather.vue'
import WhatToWear from '@/components/WhatToWear.vue'

export default {
  name: 'HomeView',
  components: {
    SearchTheWeather,
    WhatToWear
  }
}
</script>

<style>

.home{
  display: grid;
}

#searchComponent{
  grid-column-start: 1;
}

#whatToWearComponent{
  grid-column-end: -1;
}

</style>
