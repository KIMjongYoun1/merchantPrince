<template>
    <div>
    <h1>Login</h1>
    <form @submit.prevent="login">
        <label for="userId">User ID</label>
        <input id="userId" v-model="userId" type="text" required />

        <label for="password">Password</label>
        <input id="password" v-model="password" type="password" required />

        <button type="submit">Login GO!</button>
    </form>
</div>
</template>

<script>

import axios from "axios";

export default {
    name: "UserLogin",
    data(){
        return {
            userId:"",
            password:"",
        };
    },
    methods: {
        async login(){
            try {
                // api호출 백앤드 /login
                console.log("로그인 데이터", {
                    userId: this.userid,
                    password: this.password,
                });
                const response = await axios.post("http://localhost:10005/users/login", {
                userId: this.userId,
                password: this.password,
                });
                alert("로그인 성공");
                console.log("로그인", response.data);

                // 로그인 성공후 이동페이지
                this.$router.push("/profile");
            } catch (error) {
                this.erroMessage = "아이디 혹은 비밀번호를 확인후 다시 시도해주세요";
                console.error("로그인 실패", error);
            }
        },
    },
};

</script>