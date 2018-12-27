package com.baizhi.fl.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lenovo on 2018/7/5.
 */
public class User implements Serializable {
    private String id;
    private String name;
    private String dharmName; // 法名
    private String  photo;
    private String phoneNum;
    private String  password;
    private String  sex;
    private String  province;
    private String  city;
    private String  sign;
    private Integer status;
    private String  salt;
    @JSONField(format = "yyyy-MM-dd")
    private Date  createTime;

    public User() {
    }

    public User(String id, String name, String dharmName, String photo, String phoneNum, String password, String sex, String province, String city, String sign, Integer status, String salt, Date createTime) {
        this.id = id;
        this.name = name;
        this.dharmName = dharmName;
        this.photo = photo;
        this.phoneNum = phoneNum;
        this.password = password;
        this.sex = sex;
        this.province = province;
        this.city = city;
        this.sign = sign;
        this.status = status;
        this.salt = salt;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDharmName() {
        return dharmName;
    }

    public void setDharmName(String dharmName) {
        this.dharmName = dharmName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dharmName='" + dharmName + '\'' +
                ", photo='" + photo + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", status=" + status +
                ", salt='" + salt + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
