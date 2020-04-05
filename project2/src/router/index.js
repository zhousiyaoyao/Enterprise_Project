import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/login'
import addArticle from '@/pages/addArticle'
import articleManagement from '@/pages/articleManagement'
import recycle from '@/pages/recycleBin'
import mavonEditor from 'mavon-editor'
import Article from '@/pages/Article'
import admin from '@/pages/admin'
import 'mavon-editor/dist/css/index.css'
Vue.use(mavonEditor)
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'admin',
      component: admin,
  },{
    path: '/article',
    name: 'Article',
    component: Article,
  },{
    path: '/login',
    name: 'login',
    component: login,
    children:[
      {
        path: '/add',
        name: 'addArticle',
        component: addArticle
      },{
        path: '/management',
        name: 'articleManagement',
        component: articleManagement
      },{
        path: '/recycle',
        name: 'recycle',
        component: recycle
      }
    ]
  }
  ]
})
