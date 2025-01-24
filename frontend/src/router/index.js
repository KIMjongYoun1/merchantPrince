// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'; // Vue Router 4.x 방식
import Login from '@/components/Login.vue';
import Profile from '@/components/Profile.vue';
import Register from '@/components/Register.vue';

const routes = [
  {
    path: '/login',
    name: 'UserLogin',
    component: Login,
  },
  {
    path: '/profile',
    name: 'UserProfile',
    component: Profile,
  },
  {
    path: '/register',
    name: 'UserRegister',
    component: Register,
  },
];

const router = createRouter({
  history: createWebHistory(), // HTML5 History 모드
  routes,
});

export default router;
