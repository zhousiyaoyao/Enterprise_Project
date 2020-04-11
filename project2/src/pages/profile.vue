<template>
  <div class="login">
    <h1>Profile</h1>
  <el-form ref="form" :model="form" label-width="200px" class="form">
  <el-form-item label="Username">
    <el-input v-model="form.name" :disabled="true"></el-input>
  </el-form-item>
  <el-form-item label="New Password">
        <el-input type="password" v-model="form.password" placeholder="new password"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">Change</el-button>
  </el-form-item>
</el-form>
  </div>
</template>

<script>
export default {
    data() {
        return {
            defaultData: "preview",
            form: {
              name: '',
              password: '',
            }
        };
    },
    methods: {
      onSubmit() {
        alert("Success!")
      },
      refresh(){
        this.form.name = localStorage.getItem("name")
      }
    },
    mounted(){
      this.refresh()
    }
}
</script>
<style scoped>
.form{
  margin-top: 50px;
}
</style>