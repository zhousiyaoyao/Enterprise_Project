<template>
  <div class="login">
     <headder></headder>
  <el-row>
  <el-col :span="5">
   <siderbar></siderbar>
  </el-col>
  <el-col :span="19">
    <div class="main">
      <router-view></router-view>
    </div>
  </el-col>
  </el-row>
     <footter></footter>
  </div>
</template>

<script>
import siderbar from '@/components/siderbar'
import headder from '@/components/headder'
import footter from '@/components/footter'
export default {
  components:{
      siderbar,
      headder,
      footter
  },
}
</script>
<style scoped>
.main{
    position: absolute;
    margin-left: 100px;
}
</style>