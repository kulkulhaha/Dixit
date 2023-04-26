<script setup lang="ts">
import {RouterLink, RouterView} from 'vue-router'
import Header from "@/components/Header.vue";

</script>

<template>
    <Header/>

    <div class="big">
            <img  src="src/assets/img/background-gafab6dd08_1920.jpg">
    </div>
    <div class="ref">
        <a href="/">DIXIT</a>
    </div>
   <RouterView />
</template>



<style>
.big{
    max-height: 200px;
    overflow: hidden;

}
img{
    z-index: 2;
    position: relative;
    margin-top: -15%;
}
.ref{
    background-color: #828D5E77;
    color: white;
    font-size: 100px;
    z-index: 1;
    position: relative;
    margin: 0px;
}
a{
    text-decoration: none;
    color : white;
}
</style>