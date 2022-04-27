<template>
  <div id="about">
    <h3 class="aboutTitle">About Wear-ther</h3>

      <p class="aboutDescription">
        Wear-ther is a place that combines the weather and reccomendations for what to wear for the current conditions! We take reccommendations a
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
  justify-content: center;
  align-items: center;
}

.aboutTitle{
  justify-content: left;
  align-items: left;
}

a {
  
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