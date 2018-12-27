package com.baizhi.fl.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lenovo on 2018/7/8.
 */
public class Counter implements Serializable {
    private String id;
    private String name;
    private Integer coun;
    private Date latestTime;
    private Date createTime;

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

    public Integer getCoun() {
        return coun;
    }

    public void setCoun(Integer coun) {
        this.coun = coun;
    }

    public Date getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(Date latestTime) {
        this.latestTime = latestTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Counter() {
    }

    public Counter(String id, String name, Integer coun, Date latestTime, Date createTime) {
        this.id = id;
        this.name = name;
        this.coun = coun;
        this.latestTime = latestTime;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", coun=" + coun +
                ", latestTime=" + latestTime +
                ", createTime=" + createTime +
                '}';
    }
}
