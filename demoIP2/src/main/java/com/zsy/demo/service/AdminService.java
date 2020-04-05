package com.zsy.demo.service;
import com.zsy.demo.entity.Admin;


public interface AdminService {
    Admin login(String a_name);

    void insert(Admin admin);

    Admin findByName(String a_name);
}
