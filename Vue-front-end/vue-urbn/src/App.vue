<template>
  <div id="app">
    <div id="title">
      <h1 id="mainTitle"> What's The Wear-ther? </h1>

  <SearchTheWeather/>
    </div>
  </div>
</template>

<script>
import SearchTheWeather from './components/SearchTheWeather.vue'

export default {
  name: 'App',
  components: {
    SearchTheWeather
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
