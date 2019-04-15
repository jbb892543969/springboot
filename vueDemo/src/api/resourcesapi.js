import axios from '@/api/config'
//获取用户菜单
export const getUserMenu = () => {
  return axios.get("getUserMenu?account=admin");
}

// export const getOperateGrade = () => {
//     return axios.get("getOperateGrade");
// }
