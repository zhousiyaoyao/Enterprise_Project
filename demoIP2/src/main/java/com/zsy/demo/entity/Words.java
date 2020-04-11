package com.zsy.demo.entity;

import java.io.Serializable;

public class Words implements Serializable{
    private int lw_id;
    private String lw_name;
    private String lw_date;
    private String lw_content;
    private String lw_for_name;
    private String lw_for_article_id;

    public int getLw_id() {
        return lw_id;
    }

    public void setLw_id(int lw_id) {
        this.lw_id = lw_id;
    }

    public String getLw_name() {
        return lw_name;
    }

    public void setLw_name(String lw_name) {
        this.lw_name = lw_name;
    }

    public String getLw_date() {
        return lw_date;
    }

    public void setLw_date(String lw_date) {
        this.lw_date = lw_date;
    }

    public String getLw_content() {
        return lw_content;
    }

    public void setLw_content(String lw_content) {
        this.lw_content = lw_content;
    }

    public String getLw_for_name() {
        return lw_for_name;
    }

    public void setLw_for_name(String lw_for_name) {
        this.lw_for_name = lw_for_name;
    }

    public String getLw_for_article_id() {
        return lw_for_article_id;
    }

    public void setLw_for_article_id(String lw_for_article_id) {
        this.lw_for_article_id = lw_for_article_id;
    }
}
