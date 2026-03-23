import { createI18n } from 'vue-i18n'
import en from './en.js'
import cn from './cn.js'

const i18n = createI18n({
  legacy: false,
  locale: localStorage.getItem('locale') || 'en',
  fallbackLocale: 'en',
  messages: {
    en,
    cn
  }
})

export default i18n
