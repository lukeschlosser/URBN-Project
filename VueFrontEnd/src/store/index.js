import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    forecast:[],
    activeWeather:{
      weatherText:'',
      temperatureC:'',
      temperatureF:'',
      hasPrecipiation:'',
      link:''
    },
    whatToWear:[],
    activeWhatToWear:{
      top:'',
      bottom:''
    }
  },
  getters: {},
  mutations: {
    SET_FORECAST(state, data){
      state.forecast=data;
    },
    SET_WHAT_TO_WEAR(state, data){
      state.whatToWear=data;
    }
  },
  actions: {},
  modules: {}
})
