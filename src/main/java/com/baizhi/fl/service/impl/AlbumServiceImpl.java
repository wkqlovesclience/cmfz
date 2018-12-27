package com.baizhi.fl.service.impl;

import com.baizhi.fl.dao.AlbumDao;
import com.baizhi.fl.dto.AlbumDto;
import com.baizhi.fl.entity.Album;
import com.baizhi.fl.service.AlbumService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2018/7/6.
 */

@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService{
    //DI
    @Resource(name = "albumDao")
    private AlbumDao dao;


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public AlbumDto queryAllAlbum(Integer page, Integer rows) {
        // 在这里计算分页 的  page   因为mapper 里不能计算
        page=(page-1)*rows;
        // 创建dto对象
        AlbumDto dto = new AlbumDto();
            // 调业务 查数据 总条数
        int total = dao.selectAllCount();
        List<Album> list = dao.selectAllAlbum(page, rows);
        dto.setTotal(total);
        dto.setRows(list);
        return dto;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Album queryOneById(String id) {
        Album album = dao.selectOneById(id);
        return album;
    }

    @Override
    public void addAlbum(Album album) {
        //生成UUID  作为主键
        String uuid = UUID.randomUUID().toString();
        album.setId(uuid);
        dao.insertAlbum(album);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<Album> queryAll() {
        List<Album> list = dao.selectAll();
        return list;
    }
}
