package com.baizhi.fl.controller;

import com.baizhi.fl.entity.Chapter;
import com.baizhi.fl.service.ChapterService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * Created by lenovo on 2018/7/7.
 */


@RequestMapping("/chapter")
@RestController
public class ChapterController {
    //DI
    @Resource(name = "chapterService")
    private ChapterService service;

    //添加
    @RequestMapping("/addChapter")
   // @ResponseBody
    public void addChapter(Chapter chapter,HttpServletRequest request,MultipartFile img){
        // 分两步  1、上传音频 2、把数据插入到数据库
        // 2把数据插入到数据库  Chapter chapter,
        //newName 为新文件名 为  url
       // service.addChapter(chapter,newName);

     //获取要上传的 真实路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        // 在真实路径下 创建 一个新的文件夹 video
        realPath=realPath+"video";  // 新文件夹的路径
        File file = new File(realPath);
        if(!file.exists()){ //判断 如果文件  不存在 则创建
            file.mkdir();
        }
        //获取文件名
        String originalFilename = img.getOriginalFilename();
        // 调用 工具类 将文件名拆分 获取后缀名
        String extension = FilenameUtils.getExtension(originalFilename);
        //防止文件上传文件名相同被覆盖  使用 uuid
        UUID uuid = UUID.randomUUID();
        //拼接形成新的文件名
        String newName=uuid+"."+extension;
        //给文件加上路径名
       String  name=realPath+"/"+newName;
        //上传文件
        try {
            img.transferTo(new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2把数据插入到数据库  Chapter chapter,
        //newName 为新文件名 为  url
        service.addChapter(chapter,newName);


    }

    // 文件的下载
    @RequestMapping("/downLoad")
    public void downLoad(HttpServletResponse response, HttpSession session, String url) throws IOException {
        //获取要下载的文件
        String realPath = session.getServletContext().getRealPath("/video");
            byte[] bs = FileUtils.readFileToByteArray(new File(realPath + "/" + url));
        //设置响应头（以附件形式下载）
        response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(url, "utf-8"));
        // 输出流
        ServletOutputStream out = response.getOutputStream();
           out.write(bs);
            if(out!=null)
                out.flush();
            if(out!=null)
                out.close();

    }



}
