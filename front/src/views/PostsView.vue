<script setup lang="ts">
import {ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";
const router = useRouter();
const posts=ref([]);
axios.get("/api/posts").then(response=>{
    response.data.data.forEach((r)=>posts.value.push(r));
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
                <div class="createdBy">{{ post.createdBy }}</div>
                <div class="regDate">{{ post.createdDate }}</div>
            </div>
        </li>
    </ul>
    <div>
        <router-link :to="{name:'write'}">글쓰기</router-link>
    </div>

</template>