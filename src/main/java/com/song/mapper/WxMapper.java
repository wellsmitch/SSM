package com.song.mapper;

import com.song.pojo.WeiXin;

import java.util.List;

public interface WxMapper {
    void insertWx(WeiXin wx);
    List<WeiXin> findAllWx();
}
