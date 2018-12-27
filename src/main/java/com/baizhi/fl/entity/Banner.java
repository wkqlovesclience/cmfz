package com.baizhi.fl.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lenovo on 2018/7/5.
 */
public class Banner implements Serializable {
    private String  id;
    private String  picName;
    private String  picPath;
    private String  description;
    private Integer status;
    @JSONField(format = "yyyy-MM-dd")
    private  Date   createTime;
    private String  url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Banner(String id, String picName, String picPath, String description, Integer status, Date createTime, String url) {
        this.id = id;
        this.picName = picName;
        this.picPath = picPath;
        this.description = description;
        this.status = status;
        this.createTime = createTime;
        this.url = url;
    }

    public Banner() {
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", picName='" + picName + '\'' +
                ", picPath='" + picPath + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", url='" + url + '\'' +
                '}';
    }
}
