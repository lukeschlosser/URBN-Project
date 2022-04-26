<template>
  <div class="home">
    <div id="searchComponent">
    <SearchTheWeather/>
    
    </div>
  </div>
</template>

<script>
import SearchTheWeather from '@/components/SearchTheWeather.vue'

export default {
  name: 'HomeView',
  components: {
    SearchTheWeather
  }
}
</script>
