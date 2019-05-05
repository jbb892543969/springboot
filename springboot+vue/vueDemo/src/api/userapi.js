import axios from '@/api/config'
//用户登录
export const userLogin = (params) => {
  return axios.post("/user/login", params, {
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  });
}
//用户列表
export const userList = (params) => {
  return axios.post("/user/userList", params);
}
