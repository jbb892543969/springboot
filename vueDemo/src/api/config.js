import axios from 'axios'
import {Message} from 'element-ui'
import router from '@/router/index'

axios.defaults.baseURL = "/api"
axios.interceptors.request.use(config => {
  // let token = store.state.token;
  // if (token != null) {//将token加入head中，后台根据token进行拦截
  //     config.headers.token = token;
  // }
  return config;
}, err => {
  return Promise.reject(err)
})
axios.interceptors.response.use(response => {
  if (response.status == 200) {//请求通过，正常返回响应,包括拦截器拦截情况
    if (response.data.code == 403) {//用户身份过期
      Message.warning(response.data.msg)
      router.replace("/login")
    }
  }
  return response
}, (error) => {
  if (error.response.status == 500) {
    Message.error("服务器崩溃啦")
  }
  return Promise.resolve(error.response)
});
export default axios;
