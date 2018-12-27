package com.baizhi.fl.service;

import com.baizhi.fl.entity.Menu;

import java.util.List;

/**
 * Created by lenovo on 2018/7/5.
 */
public interface MenuService {
    // 查所有
    public List<Menu> queryAllMenu();
    //查所有 不连接
    public List<Menu> queryAll();
}
