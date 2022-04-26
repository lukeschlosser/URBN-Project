<template>
  <div id="app">
    <div id="title">
      <h1 id="mainTitle">What's The Wear-ther?</h1>
      <nav class="menu">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link v-bind:to="{ name: 'about' }">About</router-link>
        <router-link v-bind:to="{ name: 'contact' }">Contact Us</router-link>
      </nav>
    <router-view/>
    </div>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
