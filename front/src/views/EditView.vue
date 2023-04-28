<script setup lang="ts">
import {onMounted, ref} from "vue";
import axios from "axios";
import {useRouter} from "vue-router";

const props = defineProps({
    postId:{
        type:Number,
        required: true,
    },
});
const post = ref({
    id: 0,
    title: "",
    content: ""
});

axios.get(`/api/post/${props.postId}`).then(
    (response)=>{
        post.value=response.data;
    }
);
const router = useRouter();
const edit = () => {
    axios.patch(`/api/post/${props.postId}`,post.value).then(()=>{
       router.push({name:'posts'});
    });
};


</script>

<template>

    <div>
        <el-input v-model="post.title"/>
    </div>

    <div class="mt-2">
        <el-input v-model="post.content" type="textarea" rows="15"/>
    </div>

    <div class="mt-2">
        <el-button type="warning" @click="edit()">수정</el-button>
    </div>
</template>
