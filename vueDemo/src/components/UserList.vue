<template>
    <div>
        <el-header>
            <el-row :gutter="12">
                <el-col :span="4">
                    <el-input v-model="tableResult.queryMap.queryName" type="text" placeholder="根据用户名查询"></el-input>
                </el-col>
                <el-col :span="5">
                    <el-date-picker v-model="tableResult.queryMap.queryDate" :editable="false" type="date" placeholder="选择登录日期"
                            :picker-options="dateOption"></el-date-picker>
                </el-col>
                <el-col :span="1">
                    <el-button type="primary" @click="queryUser" icon="el-icon-search">查询</el-button>
                </el-col>
            </el-row>
        </el-header>
        <el-main>
            <el-table ref="multipleTable"
                      :data="tableResult.lists"
                      tooltip-effect="dark"
                      style="width: 100%" @selection-change="selectUser">
                <el-table-column
                        type="selection"
                        width="55">
                </el-table-column>
                <el-table-column align="center" prop="realName" label="用户姓名"/>
                <el-table-column align="center" prop="username" label="用户账号"/>
                <el-table-column align="center" prop="phone" label="用户手机号"/>
                <el-table-column align="center" prop="address" label="用户地址"/>
                <el-table-column align="center" :formatter="formatterStatus" prop="userStatus" label="当前状态"/>
                <el-table-column show-overflow-tooltip align="center" prop="loginTime" label="登录时间"/>
                <el-table-column width="168" label="操作" align="center">
                    <template slot-scope="scope">
                        <el-button type="success" @click="editUser(scope.$index,scope.row)" size="mini">编辑</el-button>
                        <el-button type="danger" @click="lockUser(scope.$index,scope.row)" size="mini">
                            {{scope.row.userStatus == 1 ? '锁定' : '解锁'}}
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
            <br>
            <el-pagination background layout="prev, pager, next, jumper,total" :page-size="tableResult.currTotal"
                           :total="tableResult.total" :current-page="tableResult.currPage"
                           @current-change="currChange"/>
        </el-main>
    </div>
</template>

<script>
    import {userList} from "../api/userapi";


    export default {
        name: "UserList",
        data() {
            return {
                //日期选项
                dateOption: {
                    //禁用日期
                    disabledDate(time) {
                        return time.getTime() > Date.now();
                    },
                    shortcuts: [{
                        text: '今天',
                        onClick(picker) {
                            picker.$emit('pick', new Date());
                        }
                    }, {
                        text: '昨天',
                        onClick(picker) {
                            const date = new Date();
                            date.setTime(date.getTime() - 3600 * 1000 * 24);
                            picker.$emit('pick', date);
                        }
                    }, {
                        text: '一周前',
                        onClick(picker) {
                            const date = new Date();
                            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
                            picker.$emit('pick', date);
                        }
                    }]
                },
                tableResult: {
                    queryMap: {//查询条件，后台用map接收
                        queryName:null,
                        queryDate:null
                    },
                    currPage: 1,//当前页数
                    currTotal: 1,//当前页记录总数
                    total: null,//总记录数
                    countPage: null//总页数
                },
                selectUsers: [],//被选中的用户
            }
        },
        methods: {
            queryUser() {//查询用户
                //当前页初始化
                this.tableResult.currPage = 1;
                this.init();
            },
            currChange(currPage) {//点击页面跳转
                this.tableResult.currPage = currPage;
                this.init();
            },
            editUser(index, row) {//编辑按钮事件
                this.$message.success(index + '' + row)
            },
            lockUser(index, row) {//锁定按钮事件
                this.$message.success(index + '' + row)
            },
            //状态格式化
            formatterStatus(row, column, cellValue, index) {
                if (cellValue == 1) {
                    return '正常'
                }
                else {
                    return '锁定'
                }
            },
            selectUser(val) {//复选框选择
                this.selectUsers = val;
            },
            init() {//表格初始化
                userList(this.tableResult).then(response => {
                    //用户及条件数据
                    this.tableResult = response.data;
                })
            }
        },
        mounted() {//数据初始化
            this.init();
        }
    }
</script>

<style scoped>

</style>