/**
 * 用户登录, 信息管理
 */
import { login } from '@/api/user'
import { Message } from 'element-ui'
import { saveToken } from '@/util/storage_token'
import router from '@/router'

export default {
  namespaced: true,
  state: {
    userInfo: {},
    userToken: ''
  },
  getters: {},
  mutations: {
    SAVE_USER (state, user) {
      state.userInfo = user
    },
    SAVE_TOKEN (state, token) {
      state.token = token
    }
  },
  actions: {
    async doLogin ({ commit }, user) {
      const {
        code,
        data
      } = await login(user)
      // 登录失败
      if (code === 201) {
        Message.error(data)
        return
      }
      // 存取token
      saveToken(data?.token)
      router.push({path: '/',replace: true})
      let username = data.userMsg.userName
      Message({
        message: `欢迎${username}的加入`,
        type: 'success'
      })
    }
  }
}

