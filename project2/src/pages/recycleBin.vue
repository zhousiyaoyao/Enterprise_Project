<template>
  <div class="login">
    <h1>Recycle Bin</h1>
      <el-table
    :data="tableData"
    style="width: 1200px">
    <el-table-column
      label="Article ID"
      prop="r_id">
    </el-table-column>
    <el-table-column
      label="Article Description"
      prop="r_summary">
    </el-table-column>
    <el-table-column
      label="Author"
      prop="r_author">
    </el-table-column>
    <el-table-column
      label="Date"
      prop="r_date">
    </el-table-column>
    <el-table-column
      label="Status"
      prop="r_status">
    </el-table-column>
    <el-table-column
      label="Action"
      align="right">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="success"
          @click="handleEdit(scope.$index, scope.row)">Recover</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>
  </div>
</template>

<script>
  import qs from 'qs'
  export default {
    data() {
      return {
        orders: []
      }
    },
    computed:{
      tableData(){
        return this.orders
      }
    },
    methods: {
      handleEdit(index, row) {
        this.$axios({
          method: "post",
          url: "http://127.0.0.1:8888/demo/super/recover",
          data: this.$qs.stringify({
            r_id: row.r_id
          })
        }).then(response => {
          this.refresh()
        }).catch(error => console.log(error, "error"))
      },

      handleDelete(index, row) {
        this.$axios({
          method: "post",
          url: "http://127.0.0.1:8888/demo/super/delete",
          data: this.$qs.stringify({
            r_id: row.r_id
          })
        }).then(response => {
          this.refresh()
        }).catch(error => console.log(error, "error"))
      },

      refresh(){
          this.$axios({
          method: "get",
          url: "http://127.0.0.1:8888/demo/super/listarticle1",
        }).then(response => {
          this.orders = response.data.articleList
        }).catch(error => console.log(error, "error"))
      }
    },
    async mounted(){
      this.$axios({
        method: "get",
        url: "http://127.0.0.1:8888/demo/super/listarticle1",
      }).then(response => {
        this.orders = response.data.articleList
      }).catch(error => console.log(error, "error"))
    }
  }
</script>
<style scoped>

</style>