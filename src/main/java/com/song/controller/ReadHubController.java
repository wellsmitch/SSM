package com.song.controller;


import com.song.pojo.ReadhubFavorite;
import com.song.pojo.User;
import com.song.service.ReadhubFavoriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ReadHubController {
    @Autowired
    ReadhubFavoriteServiceImpl readhubFavoriteServiceImpl;

    @RequestMapping(value = "item/getFavoriteList.action")
    @ResponseBody
    public SimpleJsonResult getFavoriteList(ReadhubFavorite r){
        List<ReadhubFavorite> cac = null;
        cac = readhubFavoriteServiceImpl.findReadhubFavoriteList(r);
        return new SimpleJsonResult(true, cac);
    }

    @RequestMapping(value = "asaa/getFavoriteList.action")
    @ResponseBody
    public SimpleJsonResult getFavoriteList1(ReadhubFavorite r){
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
}
