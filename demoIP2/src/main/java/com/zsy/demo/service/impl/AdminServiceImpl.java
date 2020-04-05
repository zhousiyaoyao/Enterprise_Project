package com.zsy.demo.service.impl;
import com.zsy.demo.service.AdminService;
import com.zsy.demo.entity.Admin;
import com.zsy.demo.dao.AdminDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
