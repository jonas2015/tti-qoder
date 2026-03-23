import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import Brands from '../views/Brands.vue'
import Investors from '../views/Investors.vue'
import Sustainability from '../views/Sustainability.vue'
import Careers from '../views/Careers.vue'
import News from '../views/News.vue'
import Contact from '../views/Contact.vue'
import Apply from '../views/Apply.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: About
  },
  {
    path: '/brands',
    name: 'Brands',
    component: Brands
  },
  {
    path: '/investors',
    name: 'Investors',
    component: Investors
  },
  {
    path: '/sustainability',
    name: 'Sustainability',
    component: Sustainability
  },
  {
    path: '/careers',
    name: 'Careers',
    component: Careers
  },
  {
    path: '/news',
    name: 'News',
    component: News
  },
  {
    path: '/contact',
    name: 'Contact',
    component: Contact
  },
  {
    path: '/apply',
    name: 'Apply',
    component: Apply
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes,
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    } else {
      return { top: 0 }
    }
  }
})

export default router
