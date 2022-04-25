<template>
  <div id="app">
    <div id="title">
      <h1 id="maintitle">What's The Wear-ther?</h1>

      <div class="menu">
        <router-link v-bind="{name:'home'}">Find the Wear-ther</router-link>
        <router-link v-bind="{name:'weather'}">Weather</router-link>
      </div>
    </div>

    <div id="backgroundimg" :style="{'background-image':'url(https://images.pexels.com/photos/3025562/pexels-photo-3025562.jpeg)'}">
      <router-view />
    </div>

  <div id="footer">
    <footer>
      <router-link v-bind="{name:'contact'}">Contact</router-link>
      <router-view />
    </footer>
  </div>

  </div>
</template>

<script>


export default {
  name: 'App',
  components: {
    
  }
}
</script>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
