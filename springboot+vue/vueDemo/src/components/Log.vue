<template>
    <div>
        <el-table :data="tableResult.lists">
            <el-table-column prop="roleId" label="ID" align="center"></el-table-column>
            <el-table-column prop="roleName" align="center" label="权限名称"></el-table-column>
            <el-table-column align="center" label="操作">
                <template slot-scope="scope">
                    <el-button type="success" @click="editResource(scope.$index,scope.row)" size="mini">设置资源</el-button>
                </template>
            </el-table-column>
        </el-table>
        <br>
        <el-pagination background layout="prev, pager, next, jumper,total" :page-size="tableResult.currTotal"
                       :total="tableResult.total" :current-page="tableResult.currPage"
                       @current-change="currChange"/>
        <el-dialog
                fullscreen
                :close-on-click-modal="false"
                center
                title="编辑资源"
                :visible.sync="dialogVisible"
                width="100%">
            <span><el-tree
                    :data="data2"
                    show-checkbox
                    node-key="id"
                    :default-expanded-keys="[2, 3]"
                    :default-checked-keys="[5]"
                    :props="defaultProps">
</el-tree></span>
            <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
        </el-dialog>

    </div>
</template>

<script>
    import {roleList} from '@/api/roleapi'

    export default {
        name: "Role",
        data() {
            return {
                dialogVisible: false,
                tableResult: {
                    currPage: 1,//当前页数
                    currTotal: 1,//当前页记录总数
                    total: null,//总记录数
                    countPage: null//总页数
                },
                data2: [{
                    id: 1,
                    label: '一级 1',
                    children: [{
                        id: 4,
                        label: '二级 1-1',
                        children: [{
                            id: 9,
                            label: '三级 1-1-1'
                        }, {
                            id: 10,
                            label: '三级 1-1-2'
                        }]
                    }]
                }, {
                    id: 2,
                    label: '一级 2',
                    children: [{
                        id: 5,
                        label: '二级 2-1'
                    }, {
                        id: 6,
                        label: '二级 2-2'
                    }]
                }, {
                    id: 3,
                    label: '一级 3',
                    children: [{
                        id: 7,
                        label: '二级 3-1'
                    }, {
                        id: 8,
                        label: '二级 3-2'
                    }]
                }],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                }
            }
        },
        methods: {
            currChange(currPage) {//点击页面跳转
                this.tableResult.currPage = currPage;
                this.init();
            },
            editResource(index, row) {
                this.dialogVisible = true;
            },
            init() {//表格初始化
                roleList(this.tableResult).then(res => {
                    this.tableResult = res.data;
                })
            }
        },
        mounted() {
            this.init();
        }
    }
</script>

<style scoped>

</style>