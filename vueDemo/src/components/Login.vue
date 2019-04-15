<template>
    <div id="loginDiv">
        <el-form status-icon :model="user" :rules="loginRules" ref="loginForm">
            <h3 style="text-align: center">登录</h3>

            <el-form-item prop="account">
                <el-input placeholder="用户名：" v-model="user.account"/>
            </el-form-item>

            <el-form-item prop="password">
                <el-input @keyup.native.enter="login" placeholder="密码：" type="password" v-model="user.password"/>
            </el-form-item>
            <el-row>
                <el-col :span="24"> <el-button @click="login" type="primary" round style="width: 100%">登录</el-button></el-col>
            </el-row>
        </el-form>
    </div>
</template>

<script>
    import {userLogin} from "../api/userapi";
    import {mapActions} from 'vuex'
    export default {
        name: "Login",
        data(){
            //账户校验
            let checkAccount=((rule,value,callback) => {
                if(this.$check.isNullOrUndefined(value)) {
                   return callback(new Error("账户不能为空"))
                }
                if(!this.$check.checkMaxLengrh(value,20) || !this.$check.checkMinLength(value,5)) {
                    return callback(new Error("账户长度应在5-20之间"))
                }
                return callback();
            });
            //密码校验
            let checkPsw=((rule,value,callback) => {
                if(this.$check.isNullOrUndefined(value)) {
                    return callback(new Error("密码不能为空"))
                }
                if(!this.$check.checkMaxLengrh(value,20) || !this.$check.checkMinLength(value,5)) {
                    return callback(new Error("密码长度应在5-20之间"))
                }
                return callback();
            });
            return {
                //用户登录信息
                user:{
                    account:null,
                    password:null
                },
                //校验规则
                loginRules:{
                    account:[{ validator: checkAccount, trigger: 'blur' }],
                    password:[{ validator: checkPsw, trigger: 'blur' }]
                }
            }
        },
        methods:{
                ...mapActions(['init','setToken']),
            //登录
            login() {
                let self=this;
                self.$refs.loginForm.validate((valid) => {
                    if (!valid) {
                        return false;
                    }
                    //sha1加密
                    this.user.password = $sha1.SHA1(this.user.password)
                    userLogin(this.$qs.stringify(this.user)).then(response => {
                        let res=response.data;
                        if(res.code == 200) {
                            //设置token,30分钟过期
                            // this.setToken(res.data)
                            // localStorage.setItem("token",res.data)
                            localStorage.setItem("defaultActive",'0-0');
                            this.init();//vuex初始化
                            this.$router.push("/user/userList")
                        }
                        else {
                            this.user.password = null;
                            this.$message.error(res.msg)
                        }
                    })
                })
            }
        }
    }
</script>

<style scoped>
#loginDiv {
    width: 400px;
    margin: 180px auto;
    padding: 20px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
    background-clip: padding-box;
    border-radius: 5px;
}
</style>