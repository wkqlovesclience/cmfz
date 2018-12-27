package com.baizhi.fl.service;

import com.baizhi.fl.entity.Banner;

import java.util.List;

/**
 * Created by lenovo on 2018/7/5.
 */
public interface BannerService {
    public List<Banner> queryAllBanner();
    //添加
    public void addBanner(Banner banner);
    //删除
    public void removeBannerById(String id);
    //修改
    public void modifyBanner(Banner banner);



}
