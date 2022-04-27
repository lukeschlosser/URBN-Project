import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    forecast:{},
    veryHotTop:'https://www.urbanoutfitters.com/search?q=graphictee',
    hotTop:'https://www.urbanoutfitters.com/search?q=tee%20shirt',
    mildTop:'https://www.urbanoutfitters.com/search?q=flannel',
    coldTop:'https://www.urbanoutfitters.com/search?q=crewnecksweater',
    hotBottom:'https://www.urbanoutfitters.com/search?q=shorts',
    coldBottom:'https://www.urbanoutfitters.com/search?q=pants'
    
  },
  getters: {},
  mutations: {
    SET_FORECAST(state, data){
      state.forecast=data;
    },
    // SET_WHAT_TO_WEAR(state, data){
    //   state.whatToWear=data;
    // }
  },
  actions: {},
  modules: {}
})
