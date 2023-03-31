import request from '@/api'
// 获取学校信息
export function getSchoolInfoByCondition(data) {
  return request({
    url: '/school/getSchoolInfoByCondition',
    method: 'post',
    data: data
  })
}

// 获取单个学校详细信息
export function getSchoolById(data) {
  return request({
    url: '/school/getSch',
    method: 'post',
    data: data
  })
}

// 学校排行榜
export function getSchoolRanking(data) {
  return request({
    url: '/school/order',
    method: 'post',
    data: data
  })
}


