package com.baizhi.fl.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2018/7/4.
 */
public class Menu implements Serializable{
    private String id;
    private String title;
    private String href;
    private String iconCls;
    //一张表自连接  定义关系属性
    private List<Menu> children;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Menu(String id, String title, String href, String iconCls, List<Menu> children) {
        this.id = id;
        this.title = title;
        this.href = href;
        this.iconCls = iconCls;
        this.children = children;
    }
    public Menu() {

    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", children=" + children +
                '}';
    }
}
