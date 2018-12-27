package com.baizhi.fl.service.impl;

import com.baizhi.fl.dao.AdminDao;
import com.baizhi.fl.entity.Admin;
import com.baizhi.fl.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2018/7/5.
 */

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{
    //DI
    @Resource(name = "adminDao")
    private AdminDao dao;


    @Override
    public Admin queryOneByName(String name) {
        Admin admin1 = dao.selectOneByName(name);
        return admin1;
    }
}
