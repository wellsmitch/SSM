package com.song.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class HttpTemplateAjax {
    public static String httpGet(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
        return result;
    }

    public static String httpPost(String url, String name) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(url, name, String.class).getBody();
    }

    public static void main(String str[]) {
//        https://api.readhub.cn/topic?lastCursor=&pageSize=20
        //System.out.println(HttpTemplateAjax.httpGet("http://localhost:8080/test"));
//        System.out.println(HttpTemplateAjax.httpPost("http://localhost:8080/testPost1","ming"));

        RestTemplate restTemplate = new RestTemplate();
        String lastCursor = "";
        Integer pageSize = 20;
        String url = "https://api.readhub.cn/topic?lastCursor={lastCursor}&pageSize={pageSize}";
        String forObject = restTemplate.getForObject("https://api.readhub.cn/topic", String.class, lastCursor, pageSize);
        System.out.println(forObject);


    }
}
