package com.baizhi.fl.dto;

import com.baizhi.fl.entity.Album;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2018/7/6.
 */
public class AlbumDto implements Serializable {
        private Integer total;
        private List<Album> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Album> getRows() {
        return rows;
    }

    public void setRows(List<Album> rows) {
        this.rows = rows;
    }
}
