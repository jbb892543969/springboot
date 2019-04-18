// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import element from 'element-ui'
import vueCookie from 'vue-cookies'
import check from '@/utils/check'
import sha1 from '@/utils/sha1'
import axios from '@/api/config'
import store from '@/store/index'
import qs from 'qs'
import 'element-ui/lib/theme-chalk/index.css';
import '@/assets/icon/iconfont.css'

Vue.config.productionTip = false
Vue.use(element)//使用element-ui
Vue.use(vueCookie)//使用cookie
Vue.prototype.$check = check;
Vue.prototype.$sha1 = sha1;
Vue.prototype.$ajax = axios;
Vue.prototype.$qs = qs;
/* eslint-disable no-new */

new Vue({
  el: '#app',
  router,
  store,
  components: {App},
  template: '<App/>'
})
