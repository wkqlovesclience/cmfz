package com.baizhi.fl.controller;

import com.baizhi.fl.checkcode.SecurityCode;
import com.baizhi.fl.checkcode.SecurityImage;
import com.baizhi.fl.entity.Admin;
import com.baizhi.fl.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by lenovo on 2018/7/5.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    //DI
    @Resource(name = "adminService")
    private AdminService service;

    //登录检查
    @RequestMapping("/checkName")
    public String  checkName(String name,HttpSession session,String enCode,String password){
        Admin admin = service.queryOneByName(name);
        //判断验证码是否存在
        // session 中获取验证码
        Object strcode = session.getAttribute("servcerCode");
        if(strcode!=null&& strcode.equals(enCode)){  // 验证码正确 则验证用户
            if(admin!=null && name.equals(admin.getName())&& password.equals(admin.getPassword()) ){
                    //存当前登录用户 到session
                        session.setAttribute("CurrentAdmin",admin);
                    return "redirect:/main/main.jsp";
            }else{
                return "error";
            }
        }else{
            return "error";
        }

    }


    //生成验证码
    @RequestMapping("/createImg")
    public void createImg(HttpSession session, HttpServletResponse response) throws IOException {
        //调用工具类生成验证码
        String code = SecurityCode.getSecurityCode();
        //把验证码存到 session 中
        session.setAttribute("servcerCode", code);
        // 生成验证码图片
        BufferedImage bf = SecurityImage.createImage(code);
        //设置文件的响应类型
        response.setContentType("image/jpeg");
        // 获取响应输出流
        ServletOutputStream out = response.getOutputStream();
        // 把图片打印到客户端
        ImageIO.write(bf, "jpg", out);

    }




}
