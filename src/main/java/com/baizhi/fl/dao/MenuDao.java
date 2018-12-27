package com.baizhi.fl.dao;

import com.baizhi.fl.entity.Menu;

import java.util.List;

/**
 * Created by lenovo on 2018/7/4.
 */
public interface MenuDao {
    // 查所有 自连接
    public List<Menu>  selectAllMenu();
    //查所有 不连接
    public List<Menu> selectAll();

    public Menu  selectOne(String id);
}
