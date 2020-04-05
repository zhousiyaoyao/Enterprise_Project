package com.zsy.demo.dao;

import com.zsy.demo.entity.Article;

import java.util.List;

public interface ArticleDao {
    Article queryArticleById(int Article);
    List<Article> queryArticle1();
    List<Article> queryArticle0();
    void delete(int r_id);
    void recover(int r_id);
    void recycle(int r_id);
    void saveArticle(Article article);
    Article findById(int r_id);
}
