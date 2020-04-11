package com.zsy.demo.service;

import com.zsy.demo.entity.Article;
import com.zsy.demo.entity.Reply;
import com.zsy.demo.entity.Words;


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
    void saveReply(Reply reply);
    void saveWords(Words words);
    List<Words> findByWords(int r_id);
    List<Reply> findByReply(int r_id);
}
