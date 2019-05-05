import Vue from 'vue'
import Vuex from 'vuex'
import {getUserMenu} from '@/api/resourcesapi'
// import {getOperateGrade} from "@/api/resourcesapi";

Vue.use(Vuex)

const state = {
  addRouter: [],//添加路由集合
  menuList: [],//用户菜单
  isCollapse: false,//菜单栏是否收缩
  // operateList:[],//用户拥有操作级资源
  // token:null//用户token
}
const mutations = {
  // getOperate(state,list) {
  //     state.operateList = list;
  // },
  getCollapse(state) {
    state.isCollapse = !state.isCollapse;
  },
  getUserMenu(state, menuList) {
    state.menuList = menuList;
  },
  addRouter(state, data) {
    state.addRouter = data;
    state.menuList = data;
  },
  init(state) {
    state.addRouter = [];
    state.menuList = [];
    state.isCollapse = false;
    // state.token = null;
    // state.operateList = [];
  }
  // setToken(state,token) {
  //     state.token = token;
  // }
}
const getters = {}
const actions = {
  //菜单收缩伸张
  getCollapse(state) {
    state.commit('getCollapse')
  },
  //获取用户具有菜单
  getUserMenu(state) {
    return new Promise((resolve, reject) => {
      getUserMenu().then(res => {
        resolve(res);
      }).catch(error => {
        reject(error);
      })
    })
  },
  // getOperate(state) {
  //     return new Promise((resolve, reject) => {
  //         getOperateGrade().then(res => {
  //             resolve(res)
  //         }).catch(error => {
  //             reject(error)
  //         })
  //     })
  // },
  //初始化数据
  init(state) {
    state.commit('init');
  }
  // setToken(state,token) {
  //     state.commit('setToken',token)
  // }
}
const store = new Vuex.Store({
  state,
  actions,
  mutations,
  getters
})

export default store
