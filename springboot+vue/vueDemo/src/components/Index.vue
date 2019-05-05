<template>
<el-container style="border: 1px solid #eee;height: 100%">
    <el-aside style="width: auto">
        <el-menu @select="addActive" class="el-menu-vertical-demo" unique-opened style="height: 100%" :default-active="defaultActive"
                 :collapse="isCollapse">
            <el-submenu v-for="(menu,index) in menuList" :key="menu.id" :index="''+index+''">
                <template slot="title">
                    <i class="el-icon-location"></i>
                    <span slot="title">{{menu.name}}</span>
                </template>

                <el-menu-item-group :key="item.id" v-for="(item,i) in menu.children" v-if="menu.children.length != 0" >
                    <el-menu-item @click.native="selectItem(item.path)" :index="index+'-'+i">{{item.name}}</el-menu-item>
                </el-menu-item-group>
            </el-submenu>
        </el-menu>
    </el-aside>

    <el-container>

        <el-header class="header">
            <el-row>
                <el-col :span="1"><i @click="getCollapse" style="cursor: pointer"
                                     :class="isCollapse ? 'icon-webicon03-copy' : 'icon-ego-caidan'"
                                     class="el-icon-third"></i></el-col>
                <el-col :span="23">
                    <el-dropdown style="height: 30px" placement="bottom-start">
                        <img class="userImg" src="https://i.loli.net/2017/08/21/599a521472424.jpg">
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>个人信息</el-dropdown-item>
                            <el-dropdown-item>账号设置</el-dropdown-item>
                            <el-dropdown-item divided>登出</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </el-col>
            </el-row>
        </el-header>

        <el-main>
            <el-collapse-transition>
                <router-view/>
            </el-collapse-transition>
        </el-main>
    </el-container>
</el-container>
</template>
<style>
    .header {
        background: deepskyblue;
        text-align: right;
        line-height: 60px;
        font-size:26px;
    }
    .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 200px;
        min-height: 400px;

    }
    .userImg {
        width:26px;
        height: 26px;
        border-radius: 100%;
    }
</style>

<script>
    import {mapActions} from 'vuex'
    import {mapState} from 'vuex'
    export default {
        data(){
            return {
                defaultActive: localStorage.getItem("defaultActive")
            }
        },
        methods: {
            //菜单激活，改变样式刷新后保存
            addActive(index) {
                localStorage.setItem("defaultActive",index)
            },
            //选择菜单项
            selectItem(url) {
                this.$router.push(url)
            },
            ...mapActions(['getCollapse']),
        },
        computed: {
            ...mapState(['isCollapse','menuList'])
        }
    };
</script>