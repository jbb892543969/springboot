import axios from '@/api/config'
//获取权限列表
export const roleList = (param) => {
  return axios.post("role/roleList", param);
}
