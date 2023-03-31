import axios from 'axios'
import { getToken } from '@/util/storage_token'
// 创建axios实例
const request = axios.create({
  // axios中请求配置有baseURL选项，表示请求URL公共部分
  baseURL: '/api',
  // baseURL: 'http://123.56.170.97:8083',
  // 超时
  timeout: 600000,
  // 设置Content-Type，规定了前后端的交互使用json
  headers: { 'Content-Type': 'application/json;charset=utf-8' }
})

// 添加请求拦截器
request.interceptors.request.use(
  config => {
    config.headers['token'] = getToken()
    console.table(config)
    return config
  },
  error => {
    return Promise.reject(error)
  })

// 添加响应拦截器
request.interceptors.response.use(
  response => {
    return response.data
  },
  error => {
    return Promise.reject(error)
  }
)

export default request
