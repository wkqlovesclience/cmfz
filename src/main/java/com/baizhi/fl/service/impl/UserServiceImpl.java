package com.baizhi.fl.service.impl;

import com.baizhi.fl.dao.UserDao;
import com.baizhi.fl.dto.UserSplitDto;
import com.baizhi.fl.entity.User;
import com.baizhi.fl.entity.UserDto;
import com.baizhi.fl.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lenovo on 2018/7/5.
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    //DI
    @Resource(name = "userDao")
    private UserDao dao;


    ////HSSFWorkbook    对应 这样的格式  xls
    //XHSSFWorkbook   xls


    @Override
    public UserSplitDto queryAllUserBySplit(Integer page, Integer rows) {
        page=(page-1)*rows;
        List<User> list = dao.selectAllUserBySplit(page, rows);
        Integer total = dao.selectAllUserCount();
        UserSplitDto dto = new UserSplitDto();
        dto.setTotal(total);
        dto.setRows(list);
        return dto;
    }

    @Override
    public void addUser(User user) {
        dao.insertUser(user);
    }

    @Override
    public List<User> queryAllUser() {
        List<User> list = dao.selectAllUser();
        return list;
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    // 把Controller 的方法  方法按业务层   业务层  就是处理业务   尽量不要放到 控制器层
    @Override
    public void poiExportUser(HttpServletRequest request, HttpServletResponse response) {
        //获取该对象来创建 user 表
        Workbook workbook = new HSSFWorkbook();
        //如果表中有日期 需要设置 日期格式
        DataFormat workbookDataFormat = workbook.createDataFormat();
        short shortFormat = workbookDataFormat.getFormat("yyyy年MM月dd日");
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(shortFormat);
        //创建出的execle 表的名字 user
        Sheet sheet = workbook.createSheet("user");
        //指明那一行  28 为execle 看出来的宽度  要乘以256 规定
        sheet.setColumnWidth(13, 28 * 256);
        // 表示 表格的头   数组
        String[] titels = {"编号id", "姓名", "法名", "头像", "电话号码", "密码", "性别", "省份", "城市", "签名", "状态", "盐", "注册时间"};
        // 遍历标签数组
        for (int i = 0; i < titels.length; i++) {
            //创建行 从行下标0 开始 创建
            Row row = sheet.createRow(0);
            //创建 每一个单元（）0
            row.createCell(i).setCellValue(titels[i]);
        }
        List<User> list = dao.selectAllUser();
        //遍历list 集合  把数据写入到 execle 表格
        for (int i = 0; i < list.size(); i++) {
            Row row = sheet.createRow(i + 1);// 因为 下标 0 为标题行 所以 从下一行开始
            row.createCell(0).setCellValue(list.get(i).getId());
            row.createCell(1).setCellValue(list.get(i).getName());
            row.createCell(2).setCellValue(list.get(i).getDharmName());
            row.createCell(3).setCellValue(list.get(i).getPhoto());
            row.createCell(4).setCellValue(list.get(i).getPhoneNum());
            row.createCell(5).setCellValue(list.get(i).getPassword());
            row.createCell(6).setCellValue(list.get(i).getSex());
            row.createCell(7).setCellValue(list.get(i).getProvince());
            row.createCell(8).setCellValue(list.get(i).getCity());
            row.createCell(9).setCellValue(list.get(i).getSign());
            row.createCell(10).setCellValue(list.get(i).getStatus());
            row.createCell(11).setCellValue(list.get(i).getSalt());
            row.createCell(12).setCellValue(list.get(i).getCreateTime());
        }
        //用当前时间给导出的文件名 重新命名 避免冲突
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        format = format + ".xlsx";
        // 设置响应格式  编码格式
        String fileName = null;
        try {
            fileName = new String(format.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //设置响应头
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        //设置响应的格式
        response.setContentType("application/vnd.ms-excel");
        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override  // 自定义 导出
    public void exportSomeUser(String title, String fileds) {
        Workbook workbook = new HSSFWorkbook();
        //创建的表名 自定义为 user
        Sheet sheet = workbook.createSheet("user");
        // 对 这两个参数类型为数组的 进行分割  去掉 ，
        String[] titles = title.split(",");
        String[] params = fileds.split(",");

        Row row = sheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            row.createCell(i).setCellValue(titles[i]);
        }
        //从数据库获得数据
        List<User> list = dao.selectAllUser();
        //遍历这个集合
        for (int i = 0; i < list.size(); i++) {
            //基于反射 拿到类对象
            Class<? extends User> aClass = list.get(i).getClass();
            Row row1 = sheet.createRow(i + 1);
            //遍历这个 实体总定义的 属性 数组 拼接出  getName 样的方法
            for (int j = 0; j < params.length; j++) {
                //拼接出 set 方法
                String methodName = "get" + params[j].substring(0, 1).toUpperCase() + params[j].substring(1);
                Object obj=null;
                try {
                    obj = aClass.getDeclaredMethod(methodName, null).invoke(list.get(1), null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //对日期的处理
                if(obj instanceof Date){
                    DataFormat dataFormat = workbook.createDataFormat();
                    short format = dataFormat.getFormat("yyyy年MM月dd日");
                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setDataFormat(format);
                    Cell row1Cell = row1.createCell(j);
                    row1Cell.setCellStyle(cellStyle);
                    row1Cell.setCellValue((Date) obj);
                    sheet.setColumnWidth(j,28*256);
                }else {
                    row1.createCell(j).setCellValue(String.valueOf(obj));
                }
            }

        }
        //把数据对应 写入到硬盘
        try {
            workbook.write(new FileOutputStream(new File("d:/user.xlsx")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override  //用户的活跃数量
    public List<Integer> saveAllCounts(){
        //获取一个星期的用户数量
        Integer day = dao.selectAllUserByDay();
        //获取1个月的用户数量
        Integer m1 = dao.selectAllUserByOneMoth();
        //获取2个月的用户数量
        Integer m2 = dao.selectAllUserByTwoMoth();
        //获取3个月的用户数量
        Integer m3 = dao.selectAllUserByThreeMoth();
        List<Integer> list = new ArrayList<>();
        list.add(day);
        list.add(m1);
        list.add(m2);
        list.add(m3);
         return list;
    }


   /* @Override
    public int[] saveAllCounts() {
        //获取一个星期的用户数量
        Integer day = dao.selectAllUserByDay();
        //获取1个月的用户数量
        Integer m1 = dao.selectAllUserByOneMoth();
        //获取2个月的用户数量
        Integer m2 = dao.selectAllUserByTwoMoth();
        //获取3个月的用户数量
        Integer m3 = dao.selectAllUserByThreeMoth();
        int [] bb={day,m1,m2,m3};
        return bb;
    }*/

    // 根据省查询 男性用户的数量
    @Override
    public Map<Integer, List<UserDto>> queryAllManByProvince() {
        //定义一个字符串 数组
        String[] array={"河南","黑龙江","江苏","上海","西藏","新疆","内蒙古","台湾","广东"};
        // 用map 来存储 查出来的数据
        Map<Integer, List<UserDto>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            List<UserDto> userDtoList = dao.selectAllManByProvince(array[i]);
            map.put(i,userDtoList);
        }
        return map;

    }
            // 根据省查询 女性用户的数量
    @Override
    public Map<Integer, List<UserDto>> queryAllWomanByProvince() {
        //定义一个字符串 数组
        String[] array={"河南","黑龙江","江苏","上海","西藏","新疆","内蒙古","台湾","广东"};
        // 用map 来存储 查出来的数据
        Map<Integer, List<UserDto>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            List<UserDto> userDtoList = dao.selectAllWomanByProvince(array[i]);
            map.put(i,userDtoList);
        }
        return map;
    }

    @Override
    public void importPoiUser(MultipartFile fileName) {
        //  文件的导入   分两步  先读入文件件到内存 在把数据插入到数据库
       // InputStream inputStream = fileName.getInputStream();
       // Workbook workbook = new HSSFWorkbook(inputStream);   //其实也就是这两行代码  先读入文件件到内存
        InputStream inputStream = null;
        try {
            inputStream = fileName.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Workbook workbook = null;
        try {
            workbook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置
        Sheet sheet = workbook.getSheet("user");
        System.out.println(sheet);
        List<User> list = new ArrayList<>();
        //获取表格中的数据    sheet.getLastRowNum 为表格中的最后一行
        for (int i = 1; i <=sheet.getLastRowNum(); i++) {
            //i=0 这一行的数据为标题 不需要插入数据库
            Row row = sheet.getRow(i);
            //获取单元格 的各个数据
            Cell cell = row.getCell(0);
            double did = cell.getNumericCellValue();
            String id = Double.toString(did);
            String name = row.getCell(1).getStringCellValue();
            String dharmName = row.getCell(2).getStringCellValue();
            String photo = row.getCell(3).getStringCellValue();      // excle的数字 读出来 是 数字类型  需要转
            double dphoneNum = row.getCell(4).getNumericCellValue();
            DecimalFormat format = new DecimalFormat("#");
            //对手机格式 要做一个格式的特殊处理 不然 手机格式 会不正确    不能直接 double 转成 String
            String phoneNum = format.format(dphoneNum);
           // String phoneNum = Double.toString(dphoneNum);
            double doublePassword = row.getCell(5).getNumericCellValue();
            String password = Double.toString(doublePassword);
            String sex = row.getCell(6).getStringCellValue();
            String province = row.getCell(7).getStringCellValue();
            String city = row.getCell(8).getStringCellValue();
            String sign = row.getCell(9).getStringCellValue();
            double dstatus = row.getCell(10).getNumericCellValue();
            int status=(int)dstatus;
            double  dsalt = row.getCell(11).getNumericCellValue();
            String salt = Double.toString(dsalt);
            String sDate = row.getCell(12).getStringCellValue();
            //进行日期的拆分 截取 然在拼起来 由字符串 转成 日期  在插入到数据库
            String s1 = sDate.substring(0, 4);
            String s2 = sDate.substring(5, 7);
            String s3 = sDate.substring(8, 10);
            String strDate=s1+"-"+s2+"-"+s3;

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date =null;
            try {
                date = sdf.parse(strDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            User user = new User(id, name, dharmName, photo, phoneNum, password, sex, province, city, sign, status, salt, date);
            list.add(user);
        }
        //遍历
        for (User user : list) {
            // 每次遍历 把每行数据插入数据库
             dao.insertUser(user);
        }

    }


}
