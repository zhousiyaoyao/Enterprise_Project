package com.zsy.demo.entity;

import java.io.Serializable;

public class Reply implements Serializable {
    private int lr_id;
    private String lr_name;
    private String lr_date;
    private String lr_content;
    private String lr_for_name;
    private String lr_for_words;
    private String lr_for_reply;
    private String lr_for_article_id;

    public int getLr_id() {
        return lr_id;
    }

    public void setLr_id(int lr_id) {
        this.lr_id = lr_id;
    }

    public String getLr_name() {
        return lr_name;
    }

    public void setLr_name(String lr_name) {
        this.lr_name = lr_name;
    }

    public String getLr_date() {
        return lr_date;
    }

    public void setLr_date(String lr_date) {
        this.lr_date = lr_date;
    }

    public String getLr_content() {
        return lr_content;
    }

    public void setLr_content(String lr_content) {
        this.lr_content = lr_content;
    }

    public String getLr_for_name() {
        return lr_for_name;
    }

    public void setLr_for_name(String lr_for_name) {
        this.lr_for_name = lr_for_name;
    }

    public String getLr_for_words() {
        return lr_for_words;
    }

    public void setLr_for_words(String lr_for_words) {
        this.lr_for_words = lr_for_words;
    }

    public String getLr_for_reply() {
        return lr_for_reply;
    }

    public void setLr_for_reply(String lr_for_reply) {
        this.lr_for_reply = lr_for_reply;
    }

    public String getLr_for_article_id() {
        return lr_for_article_id;
    }

    public void setLr_for_article_id(String lr_for_article_id) {
        this.lr_for_article_id = lr_for_article_id;
    }
}
