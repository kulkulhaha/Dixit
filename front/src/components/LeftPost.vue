<template>
    <el-row class="tac">
        <el-col span="5">
            <el-menu
                active-text-color="#ffd04b"
                background-color="#545c64"
                class="el-menu-vertical-demo"
                text-color="#fff"
                >

                <el-menu-item index="2">
                    <span>학교 소개</span>
                </el-menu-item>

                <el-menu-item index="3" >
                    <span>입학 안내</span>
                </el-menu-item>

                <el-menu-item index="4">
                    <span>학사 안내</span>
                </el-menu-item>
                <el-menu-item index="5">
                    <span>수업 교재</span>
                </el-menu-item>
                <el-menu-item index="6">
                    <span>신약 성경 헬라어</span>
                </el-menu-item>
                <el-menu-item index="7">
                    <span>헬라어 발음</span>
                </el-menu-item>
                <el-menu-item index="8">
                    <span>헬라어 성경을 공부하는 이유</span>
                </el-menu-item>
                <el-menu-item index="9">
                    <span>실제 수업 영상</span>
                </el-menu-item>
                <el-menu-item index="10">
                    <span>헬라어의 난이도에 따른 분류</span>
                </el-menu-item>
                <el-menu-item index="11">
                    <span>DIXIT 유튜브 링크</span>
                </el-menu-item>
                <el-menu-item index="12">
                    <span>연락처</span>
                </el-menu-item>
            </el-menu>
        </el-col>
    </el-row>

</template>
<script>
import {RouterLink} from "vue-router";

export default {
    name: 'LeftPost',
    components: {RouterLink}
}
</script>
