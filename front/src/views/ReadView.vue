<script setup lang="ts">
import axios from "axios";
import {onMounted, ref} from "vue";
const props = defineProps({
     postId:{
         type:[Number,String],
         required: true
     }
});
const post = ref(
    {
        id: 0,
        title: "",
        content: "",
    }
);
onMounted(()=>{axios.get(`/api/post/${props.postId}`)
    .then((response)=>{
        console.log(response.data.data);
        post.value=response.data.data;
    });
});
const router = useRouter();
import {useRouter} from "vue-router";
const moveToEdit = () => {
    router.push({
        name:"edit",
        params:{postId:props.postId}
    });
}
</script>

<template>
    <el-row>
        <el-col>

            <h2 class="title">{{post.title}}</h2>

            <div class="sub d-flex">
                <div class="category">개발</div>
                <div class="regDate">2023-04-23</div>
            </div>
        </el-col>
    </el-row>
    <el-row class="mt-3">
        <el-col>
            <div class="d-flex ">
                <div class="content">{{post.content}}</div>
            </div>
        </el-col>
    </el-row>
    <el-row class="mt-3">
        <el-col>
            <div class="d-flex justify-content-end">
                <el-button type="warning" @click="moveToEdit()">수정</el-button>
            </div>
        </el-col>
    </el-row>
</template>