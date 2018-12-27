package com.baizhi.fl.controller;

import com.baizhi.fl.dto.UserSplitDto;
import com.baizhi.fl.entity.User;
import com.baizhi.fl.entity.UserDto;
import com.baizhi.fl.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/8.
 */

//@RestController
@Controller
@RequestMapping("/user")
public class UserController {
    //Di
    @Resource(name = "userService")
    private UserService service;


    @RequestMapping("queryAllUser")
    @ResponseBody
    public List<User> queryAllUser(){
        List<User> list = service.queryAllUser();
        return list;
    }
        //分页
    @ResponseBody
    @RequestMapping("/queryAllUserBySplit")
    public UserSplitDto queryAllUserBySplit(Integer page,Integer rows){
        UserSplitDto splitDto = service.queryAllUserBySplit(page, rows);
        return  splitDto;
    }


    //显示统计分析使用
    @RequestMapping("/saveCounts")
    @ResponseBody
    public List<Integer> saveCounts(){
        List<Integer> list = service.saveAllCounts();
        return list;
    }

    // 查询各个省 男用户使用app 的数量分布
    @RequestMapping("/queryAllManCount")
    @ResponseBody
    public List<UserDto> queryAllManCount(){
        Map<Integer, List<UserDto>> map = service.queryAllManByProvince();
        List<UserDto> list1 = new ArrayList<>();
        Collection<List<UserDto>> lists = map.values();
        for (List<UserDto> userDtos : lists) {
            for (UserDto userDto : userDtos) {
                list1.add(userDto); //双重遍历 拿到userdto 对象
            }
        }
        return list1;
    }

    // 查询各个省 男用户使用app 的数量分布
    @ResponseBody
    @RequestMapping("/queryAllWomanCount")
    public List<UserDto> queryAllWomanCount(){
        Map<Integer, List<UserDto>> map = service.queryAllWomanByProvince();
        List<UserDto> list = new ArrayList<>();
        Collection<List<UserDto>> lists = map.values();
        for (List<UserDto> userDtos : lists) {
            for (UserDto userDto : userDtos) {
                list.add(userDto);
            }
        }
        return list;

    }




}
