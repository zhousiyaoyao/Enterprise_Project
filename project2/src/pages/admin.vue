<template>
  <div class="body">
        <el-form label-width="80px" :model="form" class="form">
            <el-form-item>
                <el-input v-model="form.name" placeholder="username"></el-input>
            </el-form-item>
            <el-form-item>
                <el-input v-model="form.password" placeholder="password"></el-input>
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
        }
        };
    },
    methods: {
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
                localstore
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
    top: 50%;
    left: 50%;
    margin-left: -200px;
    margin-top: -250px;
}
.body{
    height: 100%;
    width: 100%;
    margin: 0px;
    padding: 0px;
}
</style>