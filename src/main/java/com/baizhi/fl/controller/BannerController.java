package com.baizhi.fl.controller;

import com.baizhi.fl.entity.Banner;
import com.baizhi.fl.service.BannerService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2018/7/5.
 */

@Controller
@RequestMapping("/banner")
public class BannerController {
    //DI
    @Resource(name = "bannerService")
    private BannerService service;

    // 查所有
    @RequestMapping("queryAllBanner")
    @ResponseBody
    public  List<Banner>  queryAllBanner(){
        List<Banner> list = service.queryAllBanner();
        System.out.println(list);
        return list;
    }

    //添加
    @RequestMapping("addBanner")
    @ResponseBody                   // picPath 是我把图片路径存到这里
    public void addBanner(MultipartFile img, HttpSession session, Banner banner){
         //分两步 1 文件的上传  2, 把数据 插入到数据库
        //获取 上传文件的地方 的  真实路径  （文件上传到那）
        String realPath = session.getServletContext().getRealPath("/");
        // 创建一个要上传的文件 的存放的位置 这里上传到项目中  banner 为图片上传后 存放的文件夹
        String path = realPath + "bannerImg";
        File file = new File(path);  //  准备创建这个文件夹
        if(!file.exists()){//如果不文件存在， 则创建
                file.mkdir();
        }
       // picPath.getOriginalFilename();
        //获取文件名    1.jpg
        String originalFilename = img.getOriginalFilename();
        //防止文件被覆盖 ，修改文件名 ，获取文件名的后缀 jpg
        String extension = FilenameUtils.getExtension(originalFilename);
        UUID uuid = UUID.randomUUID();
        //把文件后缀 拼上uuid
        String newName=uuid+"."+extension;
        //给文件加上路径名
       String name=path+"/"+newName;
        //把文件上传
        try {
            img.transferTo(new File(name));  //把文件上传
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 同时数据出入到数据库
        banner.setPicPath(newName);
        service.addBanner(banner);
    }

    //删除
    @ResponseBody
    @RequestMapping("removeBanner")
    public void removeBanner(String id){
        service.removeBannerById(id);
    }

    //修改
    @RequestMapping("/modifyBanner")
    @ResponseBody
    public void modifyBanner(Banner banner){
            service.modifyBanner(banner);
    }



}
