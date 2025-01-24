<template>
    <div>
    <h1>Register</h1>
    <form @submit.prevent="register">
        <label for="userId">User ID</label>
        <input id="userId" v-model="userId" type="text" required />

        <label for="username">Name</label>
        <input id="userName" v-model="userName" type="text" required />

        <label for="password">Password</label>
        <input id="password" v-model="password" type="password" required />

        <label for="email">E-mail</label>
        <input id="email" v-model="email" type="email" required />

        <button type="submit">Register GO!</button>
    </form>
</div>
</template>

<script>

import axios from "axios";

export default {
    name: "UserRegister",
    data(){
        return {
            userId:"",
            userName:"",
            password:"",
            email:"",
        };
    },
    methods: {
        async register(){
            try {
                // api호출 백앤드 /register
                const payload = {
                    userId: this.userId,
                    userName: this.userName,
                    password: this.password,
                    email: this.email,
                };
                console.log("가입정보", payload);
                // axios를 사용해 API 호출
             const response = await axios.post("/users/register", payload);
                
                alert("로그인 성공");
                console.log("로그인", response.data);

                // 로그인 성공후 이동페이지
                this.$router.push("/login");
            } catch (error) {
                console.error("회원가입 실패", error.response || error); // 자세한 에러 정보 출력

                alert("회원가입 실패 다시 시도해주세요");
            }
        },
    },
};

</script>