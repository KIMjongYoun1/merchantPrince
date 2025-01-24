const { defineConfig } = require('@vue/cli-service');
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '/users': {
        target: 'http://localhost:10005', // Spring Boot 서버 주소
        changeOrigin: true, // 백엔드와 다른 도메인에서도 요청 허용
      },
    },
  },
});
