package com.baizhi.fl.dto;

import com.baizhi.fl.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2018/7/10.
 */
public class UserSplitDto implements Serializable {
    private Integer total;
    private List<User> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<User> getRows() {
        return rows;
    }

    public void setRows(List<User> rows) {
        this.rows = rows;
    }
}
