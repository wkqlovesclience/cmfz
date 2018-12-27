package com.baizhi.fl.controller;

import com.baizhi.fl.entity.Menu;
import com.baizhi.fl.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2018/7/5.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    //DI
    @Resource(name = "menuService")
    private MenuService service;

    // 查所有
    @RequestMapping("/queryAllMenu")
    public  List<Menu> queryAllMenu(){
        List<Menu> list = service.queryAllMenu();
        return list;
    }

    //查所有菜单   不表连接
    @RequestMapping("/queryAll")
    public List<Menu> queryAll(){
        List<Menu> menuList= service.queryAll();
        return menuList;
    }



}
