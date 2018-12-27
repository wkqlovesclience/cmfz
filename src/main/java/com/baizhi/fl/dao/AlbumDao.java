package com.baizhi.fl.dao;

import com.baizhi.fl.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/7/6.
 */
public interface AlbumDao {
    //查所有
    public List<Album> selectAllAlbum(@Param(value = "page") Integer page, @Param(value = "rows") Integer rows);
    //查数据的总条数
    public int selectAllCount();

    //查一个
    public Album selectOneById(String id);
    //添加专辑
    public void insertAlbum(Album album);

    //查所有  添加章节使用
    public List<Album> selectAll();


}
