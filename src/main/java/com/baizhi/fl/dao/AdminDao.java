package com.baizhi.fl.dao;

import com.baizhi.fl.entity.Admin;

/**
 * Created by lenovo on 2018/7/5.
 */
public interface AdminDao {
    //登录检查
    public Admin selectOneByName(String name);
}
