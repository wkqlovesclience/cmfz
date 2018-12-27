package com.baizhi.fl.service.impl;

import com.baizhi.fl.dao.BannerDao;
import com.baizhi.fl.entity.Banner;
import com.baizhi.fl.service.BannerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2018/7/5.
 */

@Service("bannerService")
@Transactional
public class BannerServiceImpl implements BannerService {
    //DI
    @Resource(name = "bannerDao")
    private BannerDao dao;


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<Banner> queryAllBanner() {
        List<Banner> list = dao.selectAllBanner();
        return list;
    }

    @Override
    public void addBanner(Banner banner) {
        // 插入时，主键用UUID 形式
        //获取UUID 并变成 String 类型
        String uuid = UUID.randomUUID().toString();
        banner.setId(uuid);
        dao.insertBanner(banner);
    }

    // 删除
    @Override
    public void removeBannerById(String id) {
        dao.deleteBannerById(id);
    }

    // 修改
    @Override
    public void modifyBanner(Banner banner) {
        dao.changeBanner(banner);
    }
}
