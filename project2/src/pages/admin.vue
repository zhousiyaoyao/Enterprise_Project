<template>
  <div class="body">
        <div class="header">
            <h2 class="text-nowrap" style="color: #393D49;text-align:center;padding-top:10%;font-family: Menlo">Article Management System</h2>
        </div>
        <el-form label-width="80px" :model="form" class="form" status-icon :rules="rules">
            <el-form-item prop="name">
                <el-input v-model="form.name" placeholder="username"></el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input type="password" v-model="form.password" placeholder="password"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="login" style="width: 100%">Login</el-button>
            </el-form-item>
            <el-form-item>
                <el-button type="success" @click="register" style="width: 100%">Register</el-button>
            </el-form-item>
        </el-form>
  </div>
</template>

<script>
export default {
    data() {
        return {
        form: {
          name: '',
          password: '',
          type: ''
        },
        rules: {
          password: [
            { required: true, validator: this.validatepassword, trigger: 'blur' }
          ],
          name: [
            { required: true, validator: this.validateusername, trigger: 'blur' }
          ],
        },
        };
    },
    methods: {
        validatepassword(rule, value, callback){
            if(!value){
                callback(new Error('Please input password'))
            }
            callback()
        },
        validateusername(rule, value, callback){
            if(!value){
                callback(new Error('Please input username'))
            }
            callback()
        },
        login(){
            this.$axios({
                method: "post",
                url: "http://127.0.0.1:8888/demo/admin/login",
                data: this.$qs.stringify({
                    a_name: this.form.name,
                    a_password: this.form.password
                })
            }).then(response => {
                console.log(response.data)
                console.log(typeof response.data)
                if(response.data === 200){
                    this.$cookies.set('name', this.form.name)
                    localStorage.setItem("name",this.form.name)
                    this.$router.push('/login')
                }else if(response.data === 402){
                    alert('Wrong Password')
                }else{
                    alert('Please Register First')
                }
            }).catch(error => console.log(error, "error"))
        },
        register(){
            this.$axios({
                method: "post",
                url: "http://127.0.0.1:8888/demo/admin/register",
                data: this.$qs.stringify({
                    a_name: this.form.name,
                    a_password: this.form.password
                })
            }).then(response => {
                this.$cookies.set('name', this.form.name)
                localStorage.setItem("name",this.form.name)
                this.$router.push('/login')
            }).catch(error => console.log(error, "error"))
        }
    }
}
</script>
<style scoped>
.form{
    position: absolute;
    width: 400px;
    height: 500px;
    top: 55%;
    left: 47%;
    margin-left: -190px;
    margin-top: -250px;
}
.body{
    height: 100%;
    width: 100%;
    margin: 0px;
    padding: 0px;
}
</style>