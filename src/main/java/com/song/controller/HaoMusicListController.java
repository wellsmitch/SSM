package com.song.controller;

import com.song.controller.SimpleHttpController;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HaoMusicListController {
    @Autowired
    SimpleHttpController SimpleHttpController;

    @RequestMapping("/Hao123NewSongList")
    @ResponseBody
    public Object Hao123NewSongList(String urlStr, String selectorRexp, String pickAttr) throws IOException {
        String htmlStr = SimpleHttpController.sendGet(urlStr);
        Document document = Jsoup.parse(htmlStr);
        String[] selectorRexpArr = selectorRexp.split(">");
        Boolean isFirst = true;
        Elements elementsPrev = null;
        for (String selec : selectorRexpArr) {
            if (isFirst) {
                if (selec.indexOf('.') == -1) {
                    elementsPrev = document.select('[' + selec + ']');

                }else {
                    elementsPrev = document.select(selec);
                }
                isFirst = false;
            }else {
                if (selec.indexOf('.') == -1) {
                    elementsPrev = document.select('[' + selec + ']');
                }else {
                    elementsPrev = elementsPrev.select(selec);
                }
            }
        }
        //循环处理每篇博客
        List<String> songList = new ArrayList<>();
        for (Element element : elementsPrev) {
            String hrefStr = element.attr(pickAttr);
            if(hrefStr.contains("//") ) {
                songList.add(hrefStr);
            }
        }
        return songList;
    }

    public static void main(String[] args) {
        Document document = Jsoup.parse("<div class='a'><a class='b'></a></div>");
        Elements select = document.select(".a.b");
        System.out.println(select);
    }
}
