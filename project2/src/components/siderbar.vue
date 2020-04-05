<template>
<el-row class="tac">
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      router>
      <el-menu-item index="/add">
          <i class="el-icon-location"></i>
          <span>Add Article</span>
      </el-menu-item>
      <el-menu-item index="/management">
        <i class="el-icon-menu"></i>
        <span slot="title">Article Management Center</span>
      </el-menu-item>
      <el-menu-item index="/recycle">
        <i class="el-icon-setting"></i>
        <span slot="title">Recycle Bin</span>
      </el-menu-item>
    </el-menu>
</el-row>
</template>
<script>
  export default {
  }
</script>
<style scoped>
.el-menu-vertical-demo{
    float: left;
    width: 400px;
    height: 1000px;
}

</style>