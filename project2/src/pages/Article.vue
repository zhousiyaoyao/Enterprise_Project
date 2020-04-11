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
        <el-button type="primary" @click="comment">Leave a message</el-button>
        <div class="container">
            <div class="comment" v-for="item in words">
                <div class="info">
                    <img class="avatar" :src="item.Avator" width="36" height="36"/>
                    <div class="right">
                        <div class="name">{{item.lw_name}}</div>
                        <div class="date">{{item.lw_date}}</div>
                    </div>
                </div>
                <div class="content">{{item.lw_content}}</div>

                <div class="control">
                    <span class="comment-reply" @click="showCommentInput(item)">
                    <span style="color: green">Reply</span>
                    </span>
                </div>
                <div class="reply">
                    <div class="item" v-for="reply in item.replys">
                        <div class="reply-content">
                            <span class="from-name">{{reply.lr_name}}</span><span>: </span>
                            <span class="to-name">@{{reply.lr_for_name}}</span>
                            <span>{{reply.lr_content}}</span>
                        </div>
                        <div class="reply-bottom">
                            <span>{{reply.lr_date}}</span>
                            <span class="reply-text" @click="showCommentInput(item, reply)">
                            <i class="iconfont icon-comment"></i>
                            <span style="color: green">Reply</span>
                            </span>
                        </div>
                    </div>
                    <transition name="fade">
                        <div class="input-wrapper" v-if="showItemId === item.lw_id">
                            <el-input class="gray-bg-input"
                                    v-model="inputComment"
                                    type="textarea"
                                    :rows="3"
                                    autofocus
                                    placeholder="Put your comment here">
                            </el-input>
                            <div class="btn-control">
                            <span class="cancel" @click="cancel">Cancel</span>
                            <el-button class="btn" type="success" round @click="commitComment(item)">Submit</el-button>
                            </div>
                        </div>
                    </transition>

                </div>
            </div>

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
              words: [],
              reply: '',
              replys: '',
              showReply: false,
              inputComment: '',
              showItemId: '',
          }
      },
      methods: {
            commitComment(item){
                console.log(item)
                var now = new Date().getTime();
                let m = this.$moment(now).format('YYYY-MM-DD h:mm:ss')
                this.$axios({
                    method: "post",
                    url: "http://127.0.0.1:8888/demo/super/saveReply",
                    data: this.$qs.stringify({
                        lr_name: localStorage.getItem("name"),
                        lr_date: m,
                        lr_content: this.inputComment,
                        lr_for_article_id: parseInt(this.$route.query.ID),
                        lr_for_name: item.lw_name,
                        lr_for_words: item.lw_id,
                        lr_for_reply: item.replys.length === 0 ? null : localStorage.getItem('replyID'),
                        lr_for_article_id: item.lw_for_article_id
                    })
                }).then(response => {
                    this.$router.go(0)
                }).catch(error => console.log(error, "error"))
            },
            showCommentInput(item, reply) {
                if (reply) {
                    console.log(reply)
                    localStorage.setItem("replyID",reply.lr_id)
                    this.inputComment = "@" + reply.lr_name + " "
                } else {
                    this.inputComment = ''
                }
                this.showItemId = item.lw_id
            },
            cancel() {
                this.showItemId = ''
             },
            refresh(){
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
                    // this.orders = response.data.articleList
                }).catch(error => console.log(error, "error"))
            },
            getComment(){
                this.$axios({
                    method: "get",
                    url: "http://127.0.0.1:8888/demo/super/listword",
                    params: {
                        r_id: parseInt(this.$route.query.ID)
                    }
                }).then(response => {
                    this.words = response.data.Words
                    this.words.forEach((ele) => {
                        Object.assign(ele, {replys: []})
                        Object.assign(ele, {Avator: 'http://img.zcool.cn/community/0117e2571b8b246ac72538120dd8a4.jpg@1280w_1l_2o_100sh.jpg'})
                    })
                    for(var i = 0; i < this.replys.length; i++){
                        for(var j = 0; j < this.words.length; j++){
                            if(this.replys[i].lr_for_words == this.words[j].lw_id){
                                this.words[j].replys.push(this.replys[i])
                            }
                        }
                    }
                    console.log(this.words)
                }).catch(error => console.log(error, "error"))
            },
            getReply(){
                this.$axios({
                    method: "get",
                    url: "http://127.0.0.1:8888/demo/super/listreply",
                    params: {
                        r_id: parseInt(this.$route.query.ID)
                    }
                }).then(response => {
                    this.replys = response.data.Reply
                }).catch(error => console.log(error, "error"))
            },
            comment(){
                var now = new Date().getTime();
                let m = this.$moment(now).format('YYYY-MM-DD h:mm:ss')
                this.$axios({
                    method: "post",
                    url: "http://127.0.0.1:8888/demo/super/saveWords",
                    data: this.$qs.stringify({
                        lw_name: localStorage.getItem("name"),
                        lw_date: m,
                        lw_content: this.textarea,
                        lw_for_name: this.author,
                        lw_for_article_id: parseInt(this.$route.query.ID)
                    })
                }).then(response => {
                    // this.$router.go(0)
                    this.getComment()
                }).catch(error => console.log(error, "error"))
            }
        },
     async mounted(){
         this.refresh()
         this.getReply()
         this.getComment()
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

.container{
    padding: 0 10px;
    box-sizing: border-box;
}
.comment {
    display: flex;
    flex-direction: column;
    padding: 10px;
    border-bottom: 1px solid #F2F6FC;
}
.info {
    display: flex;
    align-items: center;
}
.right {
    display: flex;
    flex-direction: column;
    margin-left: 10px;
}
.name {
    font-size: 16px;
    color: #303133;
    margin-bottom: 5px;
    font-weight: 500;
}
.date {
    font-size: 12px;
    color: #909399;
}
.content {
font-size: 16px;
color: $text-main;
line-height: 20px;
padding: 10px 0;
}
.control {
display: flex;
align-items: center;
font-size: 14px;
color: $text-minor;
}
.comment-reply {
    display: flex;
    align-items: center;
    cursor: pointer;
}
&:hover {
color: $text-333;
}
.iconfont {
font-size: 16px;
margin-right: 5px;
}
.reply {
margin: 10px 0;
border-left: 2px solid $border-first;
}
.item {
    margin: 0 10px;
    padding: 10px 0;
    border-bottom: 1px dashed $border-third;
}

.reply-content {
display: flex;
align-items: center;
font-size: 14px;
color: $text-main;
}
.from-name {
    color: $color-main;
}
.to-name {
    color: $color-main;
    margin-left: 5px;
    margin-right: 5px;
}
.reply-bottom {
display: flex;
align-items: center;
margin-top: 6px;
font-size: 12px;
color: $text-minor;
}
.reply-text {
display: flex;
align-items: center;
margin-left: 10px;
cursor: pointer;
}
&:hover {
color: $text-333;
}
.icon-comment {
margin-right: 5px;
}

.write-reply {
    display: flex;
    align-items: center;
    font-size: 14px;
    color: $text-minor;
    padding: 10px;
    cursor: pointer;
}
    &:hover {
    color: $text-main;
    }
    .el-icon-edit {
    margin-right: 5px;
    }
.fade-enter-active, fade-leave-active {
    transition: opacity 0.5s;
}
.fade-enter, .fade-leave-to {
    opacity: 0;
}
.input-wrapper {
    padding: 10px;
}
.btn-control {
display: flex;
justify-content: flex-end;
align-items: center;
padding-top: 10px;
}
.cancel {
    font-size: 16px;
    color: $text-normal;
    margin-right: 20px;
    cursor: pointer;
}
 &:hover {
    color: $text-333;
}
.confirm {
    font-size: 16px;
}
</style>