package com.song.service;

import com.song.mapper.WxMapper;
import com.song.pojo.WeiXin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxServiceImpl implements WxService {

    @Autowired
    WxMapper wxMapper;
    public List<WeiXin> findAllWx() {
        return wxMapper.findAllWx();
    }

    public void insertWxInfo(WeiXin wx) {
        wxMapper.insertWx(wx);
    }
}
