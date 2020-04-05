package com.zsy.demo.dao;
import com.zsy.demo.entity.Admin;

public interface AdminDao {
    Admin login(String a_name);

    void insert(Admin admin);

    Admin findByName(String a_name);
}

