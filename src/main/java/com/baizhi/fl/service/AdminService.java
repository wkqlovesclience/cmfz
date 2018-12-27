package com.baizhi.fl.service;

import com.baizhi.fl.entity.Admin;

/**
 * Created by lenovo on 2018/7/5.
 */
public interface AdminService {
    //登录检查
    public Admin queryOneByName(String name);

}
