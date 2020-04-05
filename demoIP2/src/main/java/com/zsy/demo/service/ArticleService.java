package com.zsy.demo.service;

import com.zsy.demo.entity.Article;

import java.util.List;

public interface ArticleService {
    Article getArticleById(int ArticleId);
    List<Article> getArticleList1();
    List<Article> getArticleList0();
    void recover(int r_id);
    void delete(int r_id);
    void recycle(int r_id);
    void saveArticle(Article article);
    Article findById(int r_id);
}
