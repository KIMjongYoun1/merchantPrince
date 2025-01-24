// src/main.js
import { createApp } from 'vue';
import App from './App.vue';
import router from './router'; // 라우터 가져오기

// Vue 애플리케이션 생성 및 라우터 등록
const app = createApp(App);

app.use(router); // 라우터 등록
app.mount('#app'); // 앱 마운트
