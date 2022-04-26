import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Search from '../views/Search.vue'
import Weather from '../views/Weather.vue'
import Contact from '../views/Contact.vue'

Vue.use(Router)

const router = new Router({
    mode: "history",
    base: process.env.BASE_URL,
    routes: [
        {
            path: "/",
            name: "home",
            component: Home
        },
        {
            path: "/weather",
            name: "weather",
            component: Weather
        },
        {
            path: "/contact",
            name: "contact",
            component: Contact
        },
        {
            path: "/search",
            name: "search",
            component: Search
        }
    ]
})