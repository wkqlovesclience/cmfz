package com.baizhi.fl.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/7/6.
 */
public class Album implements Serializable {
    private String id;
    private String name;
    private Integer score;
    private String author;
    private String broadcast;
    private Integer count;
    private String description;
    @JSONField(format = "yyyy-MM-dd")
    private Date publishTime;
    //关系属性
    private List<Chapter> children;

    public Album() {
    }

    public Album(String id, String name, Integer score, String author, String broadcast, Integer count, String description, Date publishTime, List<Chapter> children) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.author = author;
        this.broadcast = broadcast;
        this.count = count;
        this.description = description;
        this.publishTime = publishTime;
        this.children = children;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", count=" + count +
                ", description='" + description + '\'' +
                ", publishTime=" + publishTime +
                ", children=" + children +
                '}';
    }
}
