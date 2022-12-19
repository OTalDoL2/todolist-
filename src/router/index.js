import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Formulario from '../components/Forms.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/forms',
    name: 'forms',
    component: Formulario
  }
]

const router = new VueRouter({
  routes
})

export default router
