<template>
    <div>
        <h1>Profile</h1>
        <div v-if="user">
            <p><strong>User Name :</strong>{{ user.userName }}</p>
        </div>
            <p v-else>Prifile information available</p>
    <button @click="logout">Logout</button>
    </div>
</template>

<script>
import axios from "axios";

export default {
    name: "UserProfile",
    data(){
        return {
            user : null,
        };
    },
    async created() {
        console.log(this.user);
        try {
            const response = await axios.get("/users/profile");
            this.user = response.data;
        } catch (error) {
            console.error("유저 프로필을 가져올수 없음", error);
        }
    },
    methods: {
        async logout(){
            try {
                await axios.post("/users/logout");
                alert("로그아웃 성공");
                this.$router.push("/login");
            } catch (error) {
                console.error("로그아웃 실패", error);
                alert("로그아웃 실패");
            }
        },
    },
};

</script>