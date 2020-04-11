package com.zsy.demo.service.impl;
import com.zsy.demo.service.AdminService;
import com.zsy.demo.entity.Admin;
import com.zsy.demo.dao.AdminDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;

    public Admin login(String a_name){
        return adminDao.login(a_name);
    }

    public void insert(Admin admin){
        adminDao.insert(admin);
    }

    public Admin findByName(String a_name){
        return adminDao.findByName(a_name);
    }

    public List<Admin> getAdminList() {
        return adminDao.getAdminList();
    }

    public void deleteUser(int a_id){
        adminDao.deleteUser(a_id);
    }

    public void updatePassword(String a_password, int a_id){
        adminDao.updatePassword(a_password, a_id);
    }

}
