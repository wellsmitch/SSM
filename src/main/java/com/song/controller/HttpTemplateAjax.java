package com.song.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Map;

public class HttpTemplateAjax {
    public static String httpGet(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
        return result;
    }

    public static String httpPost(String url, String name) {
        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.postForEntity(url, name, String.class).getBody();
//        restTemplate.patchForObject()
        return "";
    }

    public static void analysisJson(Object objectJson) {
        if (objectJson instanceof JSONObject) {
            JSONObject objectJson1 = (JSONObject) objectJson;
            Iterator it = objectJson1.keys();
            while (it.hasNext()) {
                String key = it.next().toString();
                Object o = objectJson1.get(key);
                if (o instanceof JSONObject) {
                    analysisJson(o);
                } else if (o instanceof JSONArray) {
                    analysisJson(o);
                } else {
                    System.out.println("key:::" + key + "value:::" + o.toString());
                }
//        System.out.println(it.next());
            }
        }else if (objectJson instanceof  JSONArray) {
            JSONArray objArray = (JSONArray)objectJson;
            for (int i = 0; i < objArray.size(); i++) {
                Object o = objArray.get(i);
                if (o instanceof JSONObject) {
                    analysisJson(o);
                } else if (o instanceof JSONArray) {
                    analysisJson(o);
                } else {
                    System.out.println("arrayValue:::" + o.toString());
                }
                analysisJson(objArray.get(i));
            }
        }
    }

    public static void main(String str[]) {
//        https://api.readhub.cn/topic?lastCursor=&pageSize=20
        //System.out.println(HttpTemplateAjax.httpGet("http://localhost:8080/test"));
//        System.out.println(HttpTemplateAjax.httpPost("http://localhost:8080/testPost1","ming"));



        RestTemplate restTemplate = new RestTemplate();
        String lastCursor = "";
        String name = lastCursor.getClass().getName();
        System.out.println(name.substring(name.lastIndexOf(".") + 1));
        System.out.println("==============");
        Integer pageSize = 20;
        String url = "https://api.readhub.cn/topic?lastCursor={lastCursor}&pageSize={pageSize}";
        String forObject = restTemplate.getForObject("https://api.readhub.cn/topic", String.class, lastCursor, pageSize);
        String a = "{\n" +
                "  \"a\": {\n" +
                "    \"y\": 234,\n" +
                "    \"e\": [222, 333,999]\n" +
                "  }\n" +
                "}";
        analysisJson(JSONObject.fromObject(a));

    }
}
