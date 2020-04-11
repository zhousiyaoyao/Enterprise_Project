package com.zsy.demo.service.impl;

import com.zsy.demo.dao.ArticleDao;
import com.zsy.demo.entity.Article;
import com.zsy.demo.entity.Reply;
import com.zsy.demo.entity.Words;
import com.zsy.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public Article getArticleById(int ArticleId) {
        System.out.println(ArticleId);
        return articleDao.queryArticleById(ArticleId);
    }
    @Override
    public List<Article> getArticleList1() {
        return articleDao.queryArticle1();
    }
    @Override
    public List<Article> getArticleList0() {
        return articleDao.queryArticle0();
    }
    @Override
    public void delete(int r_id){
        articleDao.delete(r_id);
    }
    @Override
    public void recover(int r_id){
        articleDao.recover(r_id);
    }
    @Override
    public void recycle(int r_id){
        articleDao.recycle(r_id);
    }
    @Override
    public void saveArticle(Article article) {
        articleDao.saveArticle(article);
    }
    @Override
    public Article findById(int r_id) {
        return articleDao.findById(r_id);
    }
    @Override
    public void saveReply(Reply reply) {
        articleDao.saveReply(reply);
    }
    @Override
    public void saveWords(Words words) {
        articleDao.saveWords(words);
    }
    @Override
    public List<Words> findByWords(int r_id) {
        return articleDao.findByWords(r_id);
    }
    @Override
    public List<Reply> findByReply(int r_id) {
        return articleDao.findByReply(r_id);
    }
}
