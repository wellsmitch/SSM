package com.song.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Ticks {

  /*  @Autowired
    HttpUtils httpUtils;

    public static Object ar() {
        String result = httpUtils.sendGet("https://api.weixin.qq.com/cgi-bin/token", "grant_type=client_credential&appid=wxbba0b486dc5184da&secret=1f84c124d271f5e085fc6732d30f1434");
        JSONObject jsonObject = JSONObject.parseObject(result);
        String access_token = jsonObject.getString("access_token");
        System.out.println("result============" + result);

        String result1 = httpUtils.sendGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket", "access_token=" + access_token + "&type=jsapi");
        System.out.println("result1============" + result1);

        JSONObject jsonObject1 = JSONObject.parseObject(result);
        String ticket = jsonObject1.getString("ticket");
    }*/
}
