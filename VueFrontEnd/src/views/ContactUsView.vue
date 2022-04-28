<template>
  <div id="main">
      <div id="contactform">
      <h3 id="contactTitle">Contact</h3>
      <form id="ticket" method="GET" action="https://c.tenor.com/voYdvkuMphgAAAAd/it-just-works.gif">
            <div id="question">
                <label for="question">What can we help you with? </label>
                <input id="questionInput" name="question" type="text-area" placeholder="Don't press 'Submit'" />
            </div>
            <div id="submit">
                <input type="submit" />
            </div>
        </form>
        </div>
        <div id="contactBody">
            <h4>
                &emsp;This Contact form is not functional at this time. Well...more accurately it's 
                not functional in the way you would expect a contact form to be. I like how three nav items look 
                for the menu and so here we are with this Contact view. Perhaps in future versions this will become 
                a working page or perhaps something else entirely. Whatever happens I'm glad you found your way here. 
                Thanks for spending some time in my application.
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
    justify-content: left;
    align-items: left;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-rows: 1fr 1fr 1fr;
    grid-template-areas:
    "title title title" 
    "contact contact contact"
    "paragraph paragraph paragraph";
    
    text-align: center;
    height: 70vh;
}
#main{
    display: grid;
    justify-content: center;
    align-items: center;
    
    
}

#contactform{
    grid-column-start: 2;
    background-color: #df8967;
    box-shadow: insert 0 0 0 200px;
}

.contactTitle{
    font-size: 20px;
    grid-column-start: 3;
}
#ticket{
    grid-area: contact;
    margin-bottom: 20px;
}

#question{
    margin-bottom: 10px;
    
}
#questionInput{
    display: inline-block;
    opacity: 0.7;
    border-color: rgb(146, 146, 146);
    border-style:ridge;
    
}

#contactBody{
    grid-column-start: 2;
    grid-row-start: 2;
    text-align: left;
}
h4{
    
    grid-area: paragraph;
}

</style>