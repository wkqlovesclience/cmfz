package com.baizhi.fl.service;

import com.baizhi.fl.dto.AlbumDto;
import com.baizhi.fl.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/7/6.
 */
public interface AlbumService {
    //查所有   service 的方法 是对象查一个 然后调用dao 的查所有  来分页
    public AlbumDto queryAllAlbum(@Param(value = "page") Integer page, @Param(value = "rows") Integer rows);

    //查一个
    public Album queryOneById(String id);
    //添加专辑
    public void addAlbum(Album album);
    //查所有  添加章节使用
    public List<Album> queryAll();



}
