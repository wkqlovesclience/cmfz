package com.baizhi.fl.service;

import com.baizhi.fl.dto.UserSplitDto;
import com.baizhi.fl.entity.User;
import com.baizhi.fl.entity.UserDto;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/7/5.
 */
public interface UserService {
    //分页
    public UserSplitDto queryAllUserBySplit(Integer page, Integer rows);
    //添加用户
    public void addUser(User user);

    //查所有
    public List<User> queryAllUser();

    // 把查出来的数据 存到数组
    public List<Integer> saveAllCounts();

    //根据省 查 省下的所有男性用户
    public Map<Integer, List<UserDto>> queryAllManByProvince();
    //根据省 查 省下的所有女性用户
    public Map<Integer, List<UserDto>> queryAllWomanByProvince();
    //导入用户数据
    public void importPoiUser(MultipartFile fileName);
    // 导出用户数据
    public void poiExportUser(HttpServletRequest request, HttpServletResponse response);

    // 自定义导出
    public void exportSomeUser(String title, String fileds);
}
