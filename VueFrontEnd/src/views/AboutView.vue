<template>
  <div id="about">
    <h3 class="aboutTitle">About Wear-ther</h3>

      <p class="aboutDescription">
       &emsp;Wear-ther is a place that combines the weather and clothing reccommendations for the current conditions! We take reccommendations a
        step further and link directly to the <a href="https://www.urbanoutfitters.com/" target="_blank">Urban Outfitters</a> website where you'll find exactly what you're looking for to meet your wear-ther needs.
      </p>

      <p class="aboutPicture" ></p>

  </div>
  
</template>

<script> 

export default{}

</script>

<style>

#about{
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr 1fr 1fr;
  grid-template-areas: 
  'title title title title title'
  'about about about about about';
  justify-content: center;
  align-items: center;
}

.aboutTitle{
  display: grid;
  justify-content: center;
  align-items: center;
  font-size: 140%;
  grid-area: title;
}

.aboutDescription{
  font-size: 125%;
  grid-area: about;
}

a {
  padding: none;
  text-decoration: none;
  font-weight: bold;
  color:#2c3e50;
}

a:hover:not(active) {
  background-color: #df8967;
  color: whitesmoke;

}

a:active {
  color: black;
}



</style>