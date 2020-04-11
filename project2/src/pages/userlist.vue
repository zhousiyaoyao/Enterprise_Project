<template>
  <div class="login">
    <h1>User List</h1>
      <el-table
    :data="tableData"
    style="width: 1200px">
    <el-table-column
      label="User ID"
      prop="a_id">
    </el-table-column>
    <el-table-column
      label="Username"
      prop="a_name">
    </el-table-column>
    <el-table-column
      label="Action"
      align="right">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="success"
          @click="pass_value(scope.row)">Change</el-button>
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-dialog
        title="Change Password"
        :visible.sync="dialogVisible"
        width="30%"
        >
        <el-input type="password" v-model="newPassword" placeholder="Please input newPassword"></el-input>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">Cancel</el-button>
          <el-button type="primary" @click="handleEdit()">Submit</el-button>
        </span>
  </el-dialog>
  </div>
</template>

<script>
  import qs from 'qs'
  export default {
    data() {
      return {
        orders: [],
        newPassword: '',
        dialogVisible: false,
        pass_row: null,
      }
    },
    computed:{
      tableData(){
        return this.orders
      }
    },
    methods: {
      pass_value(row){
        this.pass_row = row
        this.dialogVisible = true
        console.log(this.pass_row)
      },
      handleEdit() {
        console.log(this.pass_row)
        this.$axios({
          method: "post",
          url: "http://127.0.0.1:8888/demo/admin/updatePassword",
          data: this.$qs.stringify({
            a_id: this.pass_row.a_id,
            a_password: this.newPassword
          })
        }).then(response => {
          alert('Success!')
          this.dialogVisible = false
        }).catch(error => console.log(error, "error"))
      },

      handleDelete(index, row) {
        this.$axios({
        method: "post",
        url: "http://127.0.0.1:8888/demo/admin/deleteUser",
        data: this.$qs.stringify({
            a_id: row.a_id
        })
        }).then(response => {
        this.refresh()
        }).catch(error => console.log(error, "error"))
      },

      refresh(){
          this.$axios({
          method: "get",
          url: "http://127.0.0.1:8888/demo/admin/userList",
        }).then(response => {
          this.orders = response.data.adminList
          console.log(response.data)
        }).catch(error => console.log(error, "error"))
      }
    },
    async mounted(){
        this.refresh()
    }
  }
</script>
<style scoped>

</style>