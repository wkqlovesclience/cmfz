package com.baizhi.fl.dao;

import com.baizhi.fl.entity.Banner;

import java.util.List;

/**
 * Created by lenovo on 2018/7/5.
 */
public interface BannerDao {

    public List<Banner> selectAllBanner();
    //添加
    public void insertBanner(Banner banner);
    //删除
    public void deleteBannerById(String id);
    //修改
    public void changeBanner(Banner banner);

}
