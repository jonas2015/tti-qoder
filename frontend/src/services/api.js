import axios from 'axios'

const API_BASE_URL = import.meta.env.VITE_API_URL || '/api'

const apiClient = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json'
  }
})

export default {
  getBrands() {
    return apiClient.get('/brands')
  },

  getNews() {
    return apiClient.get('/news')
  },

  getNewsById(id) {
    return apiClient.get(`/news/${id}`)
  },

  getCareers() {
    return apiClient.get('/careers')
  },

  getAbout() {
    return apiClient.get('/about')
  },

  submitContact(contactData) {
    return apiClient.post('/contact', contactData)
  }
}
