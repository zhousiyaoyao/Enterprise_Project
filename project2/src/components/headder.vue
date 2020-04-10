<template>
    <div>
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
    <el-menu-item index="1">Management System</el-menu-item>
    <el-submenu index="2" class="login">
      <template slot="title">{{username}}</template>
        <el-menu-item>Logout</el-menu-item>
    </el-submenu>
    </el-menu>
    </div>
</template>

<script>
  export default {
    data() {
      return {
        activeIndex: '1',
        activeIndex2: '1',
        username: ''
      };
    },
    methods: {
      handleSelect() {
        this.$axios({
          method: "post",
          url: "http://127.0.0.1:8888/demo/admin/outLogin",
        }).then(response=>{
          this.$cookies.remove('name')
          localStorage.removeItem('name')
          this.$router.push('/')
        }).catch(error => console.log(error, "error"))
      },
      init(){
        this.username = this.$cookies.get('name')
      }

    },
    async mounted(){
      this.init()
    }
  }
</script>
<style scoped>
.login{
  float: right;
}
</style>