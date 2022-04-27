<template>
  <div id="app">
    <div id="title">
      <h1 id="mainTitle">What's The Wear-ther?</h1>
      <nav class="menu">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link v-bind:to="{ name: 'about' }">About</router-link>
        <router-link v-bind:to="{ name: 'contact' }">Contact Us</router-link>
      </nav>
    </div>
    <div id="content">
      <router-view/>
    </div>
    <div id="footer">
      <footer>Weather provided by Accuweather.</footer>
    </div>
  </div>
</template>

<style scoped>
#app {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
  grid-template-rows: auto 1fr 50px;
  grid-template-areas:
    "header header header header header"
    "app-content app-content app-content app-content app-content"
    "app-footer app-footer app-footer app-footer app-footer";
  font-family: 'Nanum Gothic', Helvetica, Arial, sans-serif;
  background-color: whitesmoke;
  color: #2c3e50;
  overflow: auto;
  padding: 2px 5px 5px 5px
}
#title{
  grid-area: header;
  outline-width: 0px;
}

#mainTitle{
  justify-content: center;
  align-items: center;
  color: rgb(36, 36, 36);
  font-size: 50px;
  font-family: 'Nanum Gothic', sans-serif;
  font-weight:bold;
}

#footer{
  grid-area: app-footer;
  position: relative;
  
}

.menu{
  font-size: 1rem;
  width: 100%;
}

.menu a {
  color:#2c3e50;
  padding: 15px;
  text-decoration: none;
}

.menu a:active {
  background-color:#2c3e50;
  color: black;
}

.menu a:hover:not(active) {
  background-color: #2c3e50;
  color: whitesmoke;
}

div#content {
  grid-area:auto;
  padding: 1px 15px;
  height: auto;
  background-size: cover;
  margin-top: 25px;
  min-height: 70vh;
}

</style>
