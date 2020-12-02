package com.song.controller;


import com.song.pojo.ReadhubFavorite;
import com.song.pojo.User;
import com.song.service.ReadhubFavoriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.swing.text.Document;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class ReadHubController {
    @Autowired
    ReadhubFavoriteServiceImpl readhubFavoriteServiceImpl;

    @RequestMapping(value = "item/getFavoriteList")
    @ResponseBody
    public SimpleJsonResult getFavoriteList(ReadhubFavorite r){
        List<ReadhubFavorite> cac = null;
        cac = readhubFavoriteServiceImpl.findReadhubFavoriteList(r);
        return new SimpleJsonResult(true, cac);
    }

    @RequestMapping(value = "item/deleteReadhubFavorite.action")
    @ResponseBody
    public SimpleJsonResult deleteReadhubFavorite(ReadhubFavorite r) {//@ModelAttribute("CovidAndCharge") CovidAndCharge covi

        Boolean b = readhubFavoriteServiceImpl.deleteReadhubFavorite(r);
        return new SimpleJsonResult(true, b);
    }

    @RequestMapping(value = "item/insertReadhubFavorite.action")
    @ResponseBody
    public SimpleJsonResult insertReadhubFavorite(ReadhubFavorite r) {
        Boolean b = readhubFavoriteServiceImpl.insertReadhubFavorite(r);
        return new SimpleJsonResult(true, b);
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        /*
        * User
        * name age
        * name sex
        * */
//        String forObject = restTemplate.getForObject("https://www.wellsmitch.top:4443/readhub/topic", String.class, "",20);
//        String forObject = restTemplate.getForObject("https://api.readhub.cn/topic", String.class,String.class, "",20);
//        System.out.println(forObject);

        HashMap<Object, Object> map1 = new HashMap<>();
        map1.put("a",123);
        map1.put("b",123);

        Set set = map1.entrySet();
        for (Map.Entry<Object,Object> entry : map1.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
