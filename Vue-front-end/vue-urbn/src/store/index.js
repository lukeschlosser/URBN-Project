import { createApp } from 'vue'
import { createStore } from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        weather:[],
        activeWeather:{
            weatherText:'',
            temperatureC:'',
            temperatureF:'',
            hasPrecipitation:'',
            link:''
        },
        whatToWear:[],
        activeWhatToWear:{
            top:'',
            bottom:''
        }
    },
    mutations: {
        SET_WEATHER(state, data){
            state.weather=data;
        },
        SET_WHAT_TO_WEAR(state, data){
            state.whatToWear=data;
        }
    },
    actions: {},
    modules: {}
});