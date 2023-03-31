import request from '@/api'
// 用户模块
export function login(data) {
  return request({
    url: '/user/login',
    method: 'post',
    data: data
  })
}

//注册
export function register(data) {
  return request({
    url: '/user/register',
    method: 'post',
    data: data
  })
}
