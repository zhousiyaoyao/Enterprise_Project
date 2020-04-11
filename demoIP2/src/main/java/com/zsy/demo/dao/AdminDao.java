package com.zsy.demo.dao;
import com.zsy.demo.entity.Admin;

import java.util.List;

public interface AdminDao {
    Admin login(String a_name);

    void insert(Admin admin);

    Admin findByName(String a_name);

    List<Admin> getAdminList();

    void deleteUser(int a_id);

    void updatePassword(String a_password, int a_id);
}

