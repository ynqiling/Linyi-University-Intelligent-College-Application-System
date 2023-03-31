export function saveLocalString (key, value) {
  window.localStorage.setItem(key, value)
}

export function getLocalString (key) {
  return window.localStorage.getItem(key)
}

export function saveLocalObject (key, value) {
  window.localStorage.setItem(key, JSON.stringify(value))
}

export function getLocalObject (key) {
  return JSON.parse(window.localStorage.getItem(key))
}

export function remove (key) {
  return window.localStorage.removeItem(key)
}
