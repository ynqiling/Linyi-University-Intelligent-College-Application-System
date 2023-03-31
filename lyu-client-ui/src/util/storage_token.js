import { saveLocalString, getLocalString, remove } from './storage'


/*
* token的相关操作
*/
const MY_TOKEN = 'my-token'
export function saveToken (token) {
  saveLocalString(MY_TOKEN, token)
}

export function getToken () {
  return getLocalString(MY_TOKEN)
}


export function removeToken () {
  remove(MY_TOKEN)
}

