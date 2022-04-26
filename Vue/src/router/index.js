import Vue from 'vue'
import Router from 'vue-router'
import HomePage from '../views/HomePage.vue'
import WeatherDisplay from '../views/WeatherDisplay.vue'
import ContactUs from '../views/ContactUs.vue'

Vue.use(Router)

/* May potential add authentification in the future */

const router = new Router({
    mode: "history",
    base: process.env.BASE_URL,
    routes: [
        {
            path: "/",
            name: "home",
            component: HomePage
        },
        {
            path: "/weather",
            name: "weather",
            component: WeatherDisplay
        },
        {
            path: "/contact",
            name: "contact",
            component: ContactUs
        }
    ]
})

export default router;