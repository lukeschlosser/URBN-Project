<template>
  <div class="home">
    <div id="searchComponent">
    <SearchTheWeather/>
    <div id="whatToWearComponent">
    
    </div>
    </div>
  </div>
</template>

<script>
import SearchTheWeather from '@/components/SearchTheWeather.vue'


export default {
  name: 'HomeView',
  components: {
    SearchTheWeather,
   
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
