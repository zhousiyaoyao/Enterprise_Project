<template>
  <div class="login">
    <h1>Add Article</h1>
    <mavon-editor v-model="value"/>
  <el-form ref="form" :model="form" label-width="80px" class="form">
  <el-form-item label="Author">
    <el-input v-model="form.name" :disabled="true"></el-input>
  </el-form-item>
  <el-form-item label="Date">
    <el-col :span="11">
      <el-date-picker type="date" placeholder="Date" v-model="form.date1" style="width: 100%;"></el-date-picker>
    </el-col>
  </el-form-item>
  <el-form-item label="Description">
    <el-input type="textarea" v-model="form.desc"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">Add</el-button>
    <el-button>Cancel</el-button>
  </el-form-item>
</el-form>
  </div>
</template>

<script>
export default {
    data() {
        return {
            value: '',
            defaultData: "preview",
            form: {
              name: '',
              region: '',
              date1: '',
              delivery: false,
              type: [],
              resource: '',
              desc: ''
            }
        };
    },
    methods: {
      onSubmit() {
        this.$axios({
          method: "post",
          url: "http://127.0.0.1:8888/demo/super/add",
          data: this.$qs.stringify({
            r_author: this.form.name,
            r_summary: this.form.desc,
            r_content: this.value,
            r_date: this.form.date1,
            r_status: 0
          })
        }).then(response => {
          alert("Success!")
        }).catch(error => console.log(error, "error"))
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