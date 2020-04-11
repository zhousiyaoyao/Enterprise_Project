package com.zsy.demo.dao;

import com.zsy.demo.entity.Article;
import com.zsy.demo.entity.Reply;
import com.zsy.demo.entity.Words;



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
    void saveReply(Reply reply);
    void saveWords(Words words);
    List<Words> findByWords(int r_id);
    List<Reply> findByReply(int r_id);
}
