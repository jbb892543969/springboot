import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import NotFound from '@/components/common/NotFound'
import check from '@/utils/check'
import {Message} from 'element-ui'
import store from '@/store/index'

Vue.use(Router)
const defaultRouter = [
  {
    path: '/',
    redirect: '/login',

  },
  {
    path: '/login',
    name: 'Login',
    component: Login,

  },
  {
    path: "/404",
    name: '404',
    component: NotFound
  },


]
// const asyncRouter = [
//     // 用户管理
//     {
//         path: '/index',
//         component: resolve => require(['@/components/Index.vue'], resolve),
//         children: [{
//             path: "/user/userList",
//             name: "userList",
//             component: resolve => require(['@/components/UserList.vue'], resolve)
//         }]
//     },
//     //权限管理
//     {
//         path: '/index',
//         component: resolve => require(['@/components/Index.vue'], resolve),
//         children: [{
//             path: "/role/roleList",
//             name: "Role",
//             component: resolve => require(['@/components/Log.vue'], resolve)
//         }]
//     },
//
// ]
const router = new Router({
  mode: 'history',
  routes: defaultRouter
});

//不被拦截的url
const excludeURL = ["/login", "/", "/404"]
router.beforeEach((to, from, next) => {
  //用户token
  // let token = store.state.token;
  // //不被拦截的url，通过
  if (excludeURL.indexOf(to.path) != -1) {
    next();
    return;
  }
  //页面刷新重新获取token
  // if(check.isNullOrUndefined(token)) {
  //    store.dispatch('setToken',localStorage.getItem('token'))
  // }
  if (store.state.menuList.length == 0) {
    store.dispatch('getUserMenu').then(res => {
      let response = res.data;
      let addRouter = initMenu(response.data);
      //动态添加路由
      store.commit("addRouter", addRouter)
      router.addRoutes(store.state.addRouter);
      router.addRoutes([{
        path: '*',
        redirect: '/404'
      }]);
      next();

    }).catch(error => {
      console.log(error)
      Message.error("用户权限获取失败")
      next({name: 'Login'})
    })
  }
  next();
})

export default router;

function initMenu(menuList) {
  let addRouter = [];
  menuList.forEach(menu => {
    let {
      path,
      component,
      childrens,
      name
    } = menu;
    if (!check.isNullOrUndefined(childrens)) {
      childrens = initMenu(childrens)
    }
    let router = {
      path: path,
      component(resolve) {
        require(['@/components/' + component + '.vue'], resolve)
      },
      name: name,
      children: childrens
    }
    addRouter.push(router)

  })
  return addRouter;

}
