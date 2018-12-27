package com.baizhi.fl.service.impl;

import com.baizhi.fl.dao.MenuDao;
import com.baizhi.fl.entity.Menu;
import com.baizhi.fl.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2018/7/5.
 */

@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService{
    //DI
    @Resource(name = "menuDao")
    private MenuDao dao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    // 查所有
    public List<Menu> queryAllMenu() {
        List<Menu> list = dao.selectAllMenu();
        return list;
    }

    @Override
    public List<Menu> queryAll() {
        List<Menu> list = dao.selectAll();
        return list;
    }
}
