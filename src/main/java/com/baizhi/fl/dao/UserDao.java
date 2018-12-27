package com.baizhi.fl.dao;

import com.baizhi.fl.entity.User;
import com.baizhi.fl.entity.UserDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2018/7/4.
 */
public interface UserDao {
    //查所有
    public List<User> selectAllUser();
    //添加用户
    public void insertUser(User user);

    //查询用户数据的总条数
    public Integer selectAllUserCount();
    //分页查所有
    public List<User> selectAllUserBySplit(@Param(value = "page") Integer page, @Param(value = "rows") Integer rows);
    //查询一个星期内用户的活跃数量
    public Integer selectAllUserByDay();
    //查询一个月期内用户的活跃数量
    public Integer selectAllUserByOneMoth();
    //查询2个月期内用户的活跃数量
    public Integer selectAllUserByTwoMoth();
    //查询3个月期内用户的活跃数量
    public Integer selectAllUserByThreeMoth();
    //根据省 查 省下的所有男用户
    public List<UserDto> selectAllManByProvince(String province);
    //根据省 查 省下的女用户
    public List<UserDto> selectAllWomanByProvince(String province);




}
