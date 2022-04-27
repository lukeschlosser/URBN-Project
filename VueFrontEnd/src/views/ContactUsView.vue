<template>
  <div id="main">
      <div id="contactform">
      <h3>Contact</h3>
      <form id="ticket" method="GET" action="https://c.tenor.com/voYdvkuMphgAAAAd/it-just-works.gif">
            <div id="email">
                
                <input id="e-mail" name="e-mail" type="text" placeholder="Email Address" />
            </div>
            <div id="question">
                <label for="question">What can we help you with? </label>
                <input id="question" name="question" type="text-area" placeholder="Don't press 'Submit'" />
            </div>
            <div id="submit">
                <input type="submit" />
            </div>
        </form>
        </div>
        <div>
            <h4>
                This Contact form is not functional at this time. Well...more accurately it's 
                not functional in the way you would expect a contact form to be. I like how three nav items look 
                for the menu and so here we are with this Contact view. Thanks for spending time in my application.
            </h4>
        </div>
  </div>
</template>

<script> 

export default{}

</script>

<style>
div#main{
    display: grid;
    justify-content: center;
    align-items: center;
    grid-template-columns: auto;
    grid-template-rows: auto 1fr 50px;
    grid-template-areas: 
    "contactform contactform contactform contactform contactform";
    
    text-align: center;
    height: 70vh;

}
#contactform{
    display: grid;
    justify-content: center;
    align-items: center;
    grid-area: auto;
}

h3{
    
    font-size: 20px;
}
div#email{
    
    margin-bottom: 20px;
}

div#question{
    
    margin-bottom: 20px;
}

</style>