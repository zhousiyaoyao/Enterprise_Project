<template>
    <div>
        <div class="title">
            <h3><center>{{title}}</center></h3>
        </div>
        <mavon-editor
        class="md"
        :value="value"
        :subfield = "false"
        :defaultOpen = "'preview'"
        :toolbarsFlag = "false"
        :editable="false"
        :scrollStyle="true"
        :ishljs = "true"
        ></mavon-editor>
        <hr style="margin-top: 50px;width: 1400px; height: 3px;border: none;background-color: #ddd;background-image: repeating-linear-gradient(-45deg, #fff, #fff 4px, transparent 4px, transparent 8px);"/>
        <div class="foo">
            <div style="border-left: 3px solid #f44336;">
            <br/>
            <div style="margin-bottom:8px;">
                &nbsp;&nbsp;&nbsp;&nbsp;<strong style="font-size:18px;">Author：&nbsp;&nbsp;</strong>
                <span style="font-size:16px;">{{author}}</span>
            </div>
            <div style="margin-bottom:8px;">
                &nbsp;&nbsp;&nbsp;&nbsp;<strong style="font-size:18px;">Date：&nbsp;&nbsp;</strong>
                <span style="font-size:16px;">{{date}}</span>
            </div>
            <br/>
        </div>
        <div class="input">
            <el-input
                type="textarea"
                :rows="5"
                placeholder="Make comments here"
                v-model="textarea">
            </el-input>
        </div>
        <el-button type="primary">Leave a message</el-button>
        <div class="comment">
        
        </div>
    </div>
    </div>
</template>

<script>
  export default {
      data(){
          return{
              title: '',
              value: '',
              author: '',
              date: '',
              textarea: '',
          }
      },
      methods: {
          refresh(){
            console.log(typeof parseInt(this.$route.query.ID))
            this.$axios({
                method: "get",
                url: "http://127.0.0.1:8888/demo/super/getarticlebyid",
                params: {
                    ID: parseInt(this.$route.query.ID)
                }
            }).then(response => {
                this.title = response.data.article.r_summary
                this.value = response.data.article.r_content
                this.author = response.data.article.r_author
                this.date = response.data.article.r_date.slice(0,10)
                console.log(response.data)
                // this.orders = response.data.articleList
            }).catch(error => console.log(error, "error"))
          }
      },
      async mounted(){
          this.refresh()
      }
  }
</script>
<style scoped>
.title{
    margin-top: 30px;
}
.md{
    margin-top: 30px;
    width: 1400px;
    margin-left: 200px;
}
.foo{
    margin-top:50px;
    margin-left:200px;
}
.input{
    margin-top: 50px;
    width: 1000px;
    height: 150px;
}
</style>