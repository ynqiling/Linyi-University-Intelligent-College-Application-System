import Vue from 'vue'
import VueRouter from 'vue-router'
import { getToken } from '@/util/storage_token'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: () => import('@/layout'),
    children: [
      // 首页
      {
        path: '',
        name: 'main',
        component: () => import('@/views/main')
      },
      // 学校
      {
        path: '/findSchool',
        name: 'findSchool',
        component: () => import('@/views/findSchool')
      },
      // 专业
      {
        path: '/findMajor',
        name: 'findMajor',
        component: () => import('@/views/findMajor')
      },
      // 填志愿
      {
        path: '/fillVolunteer',
        name: 'fillVolunteer',
        component: () => import('@/views/fillVolunteer')
      },
      // 排行榜
      {
        path: '/ranking',
        name: 'ranking',
        component: () => import('@/views/ranking')
      },
      // 高考资讯
      {
        path: '/collageNew',
        name: 'collageNew',
        component: () => import('@/views/collageNew')
      },

      // 查找单个学校
      {
        path: '/findSchoolToOne',
        name: 'findSchoolToOne',
        component: () => import('@/views/findSchool/findSchoolToOne')
      }

    ]
  },
  {
    path: '/loginAndRegister',
    name: 'loginAndRegister',
    component: () => import('@/views/loginAndRegister')
  }
]

const router = new VueRouter({
  routes
})

const whiteList = ['/loginAndRegister', '/']

router.beforeEach(async (to, from, next) => {
  NProgress.start()
  // 获取token
  const isLogin = getToken() != null

  if (!isLogin) {
    // 未登录
    if (whiteList.includes(to.path)) {
      next()
    } else {
      next({ path: '/loginAndRegister' })
    }
  } else {
    //登录了
    if (to.path === '/loginAndRegister') {
      next({ path: '/' })
    }
  }
  next()
})

router.afterEach((to, from) => {
  NProgress.done()
})

export default router
