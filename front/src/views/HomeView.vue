<script setup lang="ts">
import {ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";
const router = useRouter();
const posts=ref([]);
axios.get("/api/posts?page=1&size=5").then(response=>{
    response.data.data.forEach((r:any)=>{
        posts.value.push(r);
    });
});
const moveToRead = () =>{
    router.push({name:"read"})
};
</script>

<template>
    <ul>
        <li v-for="post in posts" :key="post.id">
            <div class="title">
                <router-link :to="{name: 'read', params:{postId: post.id}}">{{post.title}}</router-link>
            </div>

            <div class="content">
                {{post.content}}
            </div>
            <div class="sub d-flex">
                <div class="category">개발</div>
                <div class="regDate">2023-04-23</div>
            </div>
        </li>
    </ul>

</template>