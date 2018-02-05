// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import {routers,  appRouter} from './router';
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'
import iView from 'iview'
import 'iview/dist/styles/iview.css'
Vue.use(iView)
Vue.use(VueResource)
Vue.use(VueRouter)

Vue.config.productionTip = false

// 路由配置
const RouterConfig = {
    mode: 'history',
    routes: routers
};

const router = new VueRouter(RouterConfig);

// 判断用户是否登录
router.beforeEach((to, from, next) => {
  if (to.path == '/login') {
    localStorage.removeItem('permissions');
  }
  let permissions = JSON.parse(localStorage.getItem('permissions'));
  if (!permissions && to.path != '/login') {
    console.log('未登录状态');
    next({ 
      path: '/login'
    })
  } else {
    if (to.name) {
      next()
    } else {
      router.replace({
        name: 'error_404'
      });
      next()
    }
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})

const menuList = appRouter;