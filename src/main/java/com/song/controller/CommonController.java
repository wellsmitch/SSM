package com.song.controller;

import com.song.pojo.ReadHubTopic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CommonController {
    @RequestMapping(value = "/getOuterData")
    @ResponseBody
    /*@RequestParam
    * @Valid
    * @RequestBody
    *
    *  public static Object commonHttpRequestParamConvert(HttpServletRequest httpServletRequest, Object classModel) {
        Map<String, String> params = new HashMap<>();
        Object tempClass = classModel;
        try {
            Map<String, String[]> requestParams = httpServletRequest.getParameterMap();
            if (requestParams != null && !requestParams.isEmpty()) {
                //form格式
                requestParams.forEach((key, value) -> params.put(key, value[0]));
            } else {
                //json格式
    * */
    public SimpleJsonResult getOuterData(@RequestParam Map map) throws ClassNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        String url = (String) map.get("url");
        Object forObject = restTemplate.getForObject(url, Class.forName("com.song.pojo.ReadHubTopic"), map);
        return new SimpleJsonResult(true, forObject);
    }

    @RequestMapping(value = "/getOuterDataByJson")
    @ResponseBody
    public SimpleJsonResult getOuterDataByJson(@RequestBody Map map) {
        RestTemplate restTemplate = new RestTemplate();
        String url = (String) map.get("url");
        Object forObject = restTemplate.getForObject(url, Object.class, map);
        return new SimpleJsonResult(true, forObject);
    }
}
