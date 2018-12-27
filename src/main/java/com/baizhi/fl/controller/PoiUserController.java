package com.baizhi.fl.controller;

import com.baizhi.fl.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;


/**
 * Created by lenovo on 2018/7/8.
 */

@RestController
@RequestMapping("/poi")
public class PoiUserController {    // Excel 表格的导入导出
    //HSSFWorkbook    对应 这样的格式  xlsx
    //XHSSFWorkbook   xls
    //DI
    @Resource(name = "userService")
    private UserService service;

    // 表格的导出
    @RequestMapping("/poiExportUser")
    public void poiExportUser(HttpServletRequest request, HttpServletResponse response) {
                service.poiExportUser(request,response);
    }

    // 表格的导入
    @RequestMapping("/importPoiUser")
    @ResponseBody
    public void importPoiUser(MultipartFile fileName){
        service.importPoiUser(fileName);
    }

    //表格的导入之前 要先下载模板
    @RequestMapping("/downLoad")
    public void downLoad(String file, HttpSession session,HttpServletResponse response) throws IOException {
        //获取下载的路径
        String realPath = session.getServletContext().getRealPath("/excle");
        // 调用 工具类 读取该文件
        byte[] bytes = FileUtils.readFileToByteArray(new File(realPath + "/" + file));
        //设置响应头 (以附件的形式下载)
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(file,"utf-8"));
        ServletOutputStream out = response.getOutputStream();
        out.write(bytes);
        if(out!=null)
            out.flush();
        if(out!=null)
            out.close();

    }






    //自定义的导出
    @RequestMapping("/exportSomeUser")
    public void exportSomeUser(String title, String fileds) {
        service.exportSomeUser(title,fileds);
    }


}






