<template>

    <el-header>
    <el-menu
        class="el-menu-demo"
        mode="horizontal"
        unique-opened
        menu-trigger="click"
        router
    >


        <el-sub-menu index="0" >
            <template #title>학교 소개</template>
            <el-menu-item index="/" router>대표 인사말</el-menu-item>
            <el-sub-menu index="1">
                <template #title>강사진</template>
                <el-menu-item index="1">김성주 목사</el-menu-item>
                <el-menu-item index="1">김영희 교수</el-menu-item>
                <el-menu-item index="25">박중요 목사</el-menu-item>
                <el-menu-item index="61">이규택 목사</el-menu-item>
            </el-sub-menu>
        </el-sub-menu>

        <el-sub-menu index="3">
            <template #title>입학 안내</template>
            <el-menu-item index="2-1">지원서 제출</el-menu-item>
            <el-menu-item index="2-2">등록금 납부</el-menu-item>
        </el-sub-menu>

        <el-sub-menu index="4">
            <template #title>학사 안내</template>
            <el-menu-item index="3-1">수강</el-menu-item>
            <el-menu-item index="3-2">교과 과정</el-menu-item>
            <el-menu-item index="3-2">학사 일정</el-menu-item>

        </el-sub-menu>
        <el-menu-item index="5">수업 교재</el-menu-item>
        <el-menu-item index="6">신약 성경 헬라어</el-menu-item>
        <el-menu-item index="7">헬라어 발음</el-menu-item>
        <el-menu-item index="8">헬라어 성경을 공부하는 이유</el-menu-item>
        <el-menu-item index="9">실제 수업 영상</el-menu-item>
        <el-menu-item index="10">헬라어의 난이도에 따른 분류</el-menu-item>
        <el-menu-item index="11">DIXIT 유튜브 링크</el-menu-item>
        <el-menu-item index="12">연락처</el-menu-item>



        <el-menu-item index="/posts" >게시판</el-menu-item>
        <el-sub-menu index="30">
            <template #title>헤더 추가</template>
            <el-menu-item index="3-1">헤더</el-menu-item>
            <el-menu-item index="3-2" @click="addPost()">게시물</el-menu-item>

        </el-sub-menu>



    </el-menu>
    </el-header>


</template>
<script lang="ts" setup>
import axios from "axios";


</script>
<style>


</style>
