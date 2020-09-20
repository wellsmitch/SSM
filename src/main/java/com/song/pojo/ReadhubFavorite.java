package com.song.pojo;

import java.io.Serializable;

public class ReadhubFavorite implements Serializable {
    private static final long serialVersionUID = -4473682511144271665L;

    private Integer id;
    private String newOrder;
    private String openId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewOrder() {
        return newOrder;
    }

    public void setNewOrder(String newOrder) {
        this.newOrder = newOrder;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
