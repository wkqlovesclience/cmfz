package com.baizhi.fl.controller;

import com.baizhi.fl.dto.AlbumDto;
import com.baizhi.fl.entity.Album;
import com.baizhi.fl.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by lenovo on 2018/7/6.
 */

@Controller
@RequestMapping("/album")
public class AlbumController {
    // DI
    @Resource(name = "albumService")
    private AlbumService service;

    //查所有 分页
    @RequestMapping("/queryAllAlbum")
    @ResponseBody
    public AlbumDto  queryAllAlbum(Integer page, Integer rows){
        AlbumDto dto = service.queryAllAlbum(page, rows);
        return dto;
    }

    //查一个

    @ResponseBody
    @RequestMapping("/queryOneById")
    public List<Album> queryOneById(String id){
        Album album = service.queryOneById(id);  // 查一个拿到的是一个对象  ，而 要用数据表格展示 必须是一个数组才能展示，
        List<Album> list = new ArrayList<>();   // 所有要把对象放到list里
        list.add(album);
            return list;
    }

    //添加
    @RequestMapping("/addAlbum")
    @ResponseBody
    public void addAlbum(Album album){
            service.addAlbum(album);
    }

    // 查所有 专辑  供添加 章节 使用
    @ResponseBody
    @RequestMapping("/queryAll")
    public List<Album> queryAll(){
        List<Album> list = service.queryAll();
        return list;
    }



}
