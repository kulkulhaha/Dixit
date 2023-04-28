
<script lang="ts" setup>

import axios from "axios";
import {onMounted, ref} from "vue";
const headers = ref([]);
axios.get(`/api/header`).then((response)=>{

    response.data.data.forEach((h:any)=>{
        if (h.parentId==null){
            h.parentId=0;
        }
        headers.value.push(h);
    });

    makeHeader(headers.value,0);

});

function makeHeader(headers:any[],id:Number){

    for (let i in headers){
        let tagArea = document.getElementById(headers[i].parentId.toString());
        if (headers[i].parentId==id){
            if (headers[i].childIds.length==0){
                let new_tag = document.createElement("el-menu-item");
                let new_index = headers[i].id;
                new_tag.setAttribute('id',headers[i].id.toString());
                new_tag.innerHTML = headers[i].name;
                tagArea!.append(new_tag);
                delete headers[i];
                makeHeader(headers,new_index);
            } else{
                let el_sub_menu = document.createElement("el-sub-menu");
                let template = document.createElement("template");
                let new_index = headers[i].id;

                el_sub_menu.setAttribute('id',headers[i].id.toString());
                el_sub_menu.innerHTML = headers[i].name;
                tagArea!.append(el_sub_menu);
                delete headers[i];
                makeHeader(headers,new_index);
            }
        }
    }
}

function test(h:any[]){
    let tagArea = document.getElementById("0");
    let new_tag = document.createElement("el-menu-item");
    console.log(h.length);
    for (let i = 0; i<h.length;i++){

        new_tag.setAttribute('id',h[i].id.toString());
        new_tag.innerHTML = h[i].name;
        tagArea!.append(new_tag);


    }

}


</script>

<template>

    <el-header>
    <el-menu id="0"
        class="el-menu-demo"
        mode="horizontal"
        unique-opened
        menu-trigger="click"
        router>

    </el-menu>
    </el-header>
</template>



<style>


</style>