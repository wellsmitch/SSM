package com.song.controller;

import com.alibaba.fastjson.JSONObject;
import com.song.pojo.Message;
import com.song.pojo.User;
import com.song.pojo.WeiXin;
import com.song.service.WxServiceImpl;
import com.song.util.JssdkConfig;
import com.song.util.WeixinCheckoutUtil;
import org.jsoup.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.logging.Logger;

@Controller
public class WeixinCheckController {
//
//    @Value("${wxAppId}")
//    String appId;
//
//    @Value("${wxSecret}")
//    String wxSecret;

    @Autowired
    JssdkConfig jssdkConfig;

    @Autowired
    HttpUtils httpUtils;
    @Autowired
    WxServiceImpl userServiceImpl;


    /**
     * 微信公众号签名认证接口
     *
     * @throws
     * @Title: test
     * @Description: TODO
     * @param: @param signature
     * @param: @param timestamp
     * @param: @param nonce
     * @param: @param echostr
     * @param: @return
     * @return: String
     */
    @RequestMapping("/checkwxtoken")
    @ResponseBody
    public Long wxCheckToken(String signature, @RequestParam(value = "timestamp") String timestampData, String nonce, String echostr, WeiXin weiXin) {
        System.out.println("checkwxtoken =======================++++++++++++++++++++==============");
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        System.out.println("signature::::::" + signature);
        System.out.println("timestamp::::::" + timestampData);
        System.out.println("nonce::::::" + nonce);
        System.out.println("WeixinCheckoutUtil.checkSignature::::::::::" + WeixinCheckoutUtil.checkSignature(signature, timestampData, nonce));
        Long ec = null;
        if (signature != null && WeixinCheckoutUtil.checkSignature(signature, timestampData, nonce)) {
            System.out.println("进来了");
            System.out.println("echostr：：：：：：：" + echostr);
            ec = Long.parseLong(echostr);

//            wx.setNonce(nonce);
//            wx.setSignature(signature);
//            wx.setTimestampData(timestampData);
            userServiceImpl.insertWxInfo(weiXin);
//            userServiceImpl.insertWxInfo(wx1);


            return ec;
        }

        return ec;
    }

    @RequestMapping("/getTokenInfo")
    @ResponseBody
    public List<WeiXin> selectTokenInfo() {
        return userServiceImpl.findAllWx();
    }

    @RequestMapping("/testSession")
    @ResponseBody
    public void testSession(HttpSession httpSession) {
        Object ticket;
//        httpSession.removeAttribute("checkCode");
        Object checkCode = httpSession.getAttribute("checkCode");

        Integer a = 1;
        System.out.println(a);

        if (checkCode == null) {
            System.out.println("jinlaile");
            httpSession.setAttribute("checkCode", "123123132123");
            try {
                Timer timer = new Timer();
                //TimerTask实现5分钟后从session中删除checkCode
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        httpSession.removeAttribute("checkCode");
                        System.out.println("checkCode删除成功=========checkCode删除成功");
                        timer.cancel();
                    }
                }, 10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("aaa=======" + checkCode);
        }

      /*  try {
            Timer timer = new Timer();
            //TimerTask实现5分钟后从session中删除checkCode
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    httpSession.removeAttribute("checkCode");
                    System.out.println("checkCode删除成功=========checkCode删除成功");
                    timer.cancel();
                }
            }, 5 * 60 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }


    @RequestMapping("/getConfigInfoOfZy")
    @ResponseBody
    public Message getConfigInfoOfZy(String url, HttpSession httpSession) {
        String checkCodeZy = null;
        String appId = "wx3965f3eda47c73df";
        checkCodeZy = (String) httpSession.getAttribute("checkCodeZy");
        System.out.println(123456789);
        System.out.println("getConfigInfoOfZy--checkCode" + checkCodeZy);
        System.out.println(checkCodeZy == null);
        System.out.println(checkCodeZy == "");
        if (StringUtil.isBlank(checkCodeZy)) {
            System.out.println("getConfigInfoOfZy--jinlaile=========");
            String result = httpUtils.sendGet("https://api.weixin.qq.com/cgi-bin/token", "grant_type=client_credential&appid=" + appId + "&secret=802e923c8ce45ead18a11aa42fc8681c");
            JSONObject jsonObject = JSONObject.parseObject(result);
            Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
            String access_token = jsonObject.getString("access_token");

            System.out.println("getConfigInfoOfZy--result============" + result);

            String result1 = httpUtils.sendGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket", "access_token=" + access_token + "&type=jsapi");
            System.out.println("getConfigInfoOfZy--result1============" + result1);

            JSONObject jsonObject1 = JSONObject.parseObject(result1);
            String ticket = jsonObject1.getString("ticket");
            System.out.println("getConfigInfoOfZy--ticket============" + ticket);


            httpSession.setAttribute("checkCodeZy", ticket);
            checkCodeZy = (String) httpSession.getAttribute("checkCodeZy");
            System.out.println("getConfigInfoOfZy--checkCodecheckCodecheckCode===" + checkCodeZy);
            try {
                Timer timer = new Timer();
                //TimerTask实现5分钟后从session中删除checkCode

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        httpSession.removeAttribute("checkCodeZy");
                        System.out.println("getConfigInfoOfZy--checkCode删除成功=========checkCode删除成功");
                        timer.cancel();
                    }
                }, 1000 * 7000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            checkCodeZy = (String) httpSession.getAttribute("checkCodeZy");
        }

        System.out.println("getConfigInfoOfZy--aaa=======" + checkCodeZy);

        try {
            Map<String, String> configMap = JssdkConfig.jsSDK_Sign(URLDecoder.decode(url,"UTF-8"), checkCodeZy, appId);
            return Message.success(configMap);
        } catch (Exception e) {
            return Message.err("getConfigInfoOfZy--有异常出现");
        }
    }


    @RequestMapping("/getConfigInfo")
    @ResponseBody
    public Message getConfigInfo(String url, HttpSession httpSession) {
        String mycheckCode = null;
        mycheckCode = (String) httpSession.getAttribute("checkCode");

        if (mycheckCode == null) {
            System.out.println("jinlaile=========");
            String result = httpUtils.sendGet("https://api.weixin.qq.com/cgi-bin/token", "grant_type=client_credential&appid=wxbba0b486dc5184da&secret=1f84c124d271f5e085fc6732d30f1434");
            JSONObject jsonObject = JSONObject.parseObject(result);
            Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
            String access_token = jsonObject.getString("access_token");

            System.out.println("result============" + result);

            String result1 = httpUtils.sendGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket", "access_token=" + access_token + "&type=jsapi");
            System.out.println("result1============" + result1);

            JSONObject jsonObject1 = JSONObject.parseObject(result1);
            String ticket = jsonObject1.getString("ticket");
            System.out.println("ticket============" + ticket);


            httpSession.setAttribute("mycheckCode", ticket);
            mycheckCode = (String) httpSession.getAttribute("mycheckCode");
            System.out.println("checkCodecheckCodecheckCode===" + mycheckCode);
            try {
                Timer myTimer = new Timer();
                //TimerTask实现5分钟后从session中删除checkCode



                myTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        httpSession.removeAttribute("mycheckCode");
                        System.out.println("mycheckCode 删除成功=========mycheckCode 删除成功");
                        myTimer.cancel();
                    }
                }, 1000 * 7000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            mycheckCode = (String) httpSession.getAttribute("mycheckCode");
        }

        System.out.println("aaa=======" + mycheckCode);

        try {
            Map<String, String> configMap = JssdkConfig.jsSDK_Sign(url, mycheckCode, "wxbba0b486dc5184da");
            return Message.success(configMap);
        } catch (Exception e) {
            return Message.err("有异常出现");
        }
    }

    @RequestMapping("/getWxInfo")
    @ResponseBody
    public Message getWxInfo(String code, HttpSession httpSession) {
//    public String getWxInfo(String code, HttpSession httpSession) {
//        return "aaaaaaaaaaa";
        String APPID = "wx87c0971e9120297f";
        String SECRET = "8eaec4ad3f80f7d2f564270e539228c5";
        System.out.println("code:::::::::::" + code);
        String accessToken = (String) httpSession.getAttribute("accessToken");
        System.out.println("accessToken:::::::::::" + accessToken);

        String openid = (String) httpSession.getAttribute("openid");
        if (accessToken == null) {
            // code 换取access_token
            String accessTokenString = httpUtils.sendGet("https://api.weixin.qq.com/sns/oauth2/access_token", "appid=" + APPID + "&secret=" + SECRET + "&grant_type=authorization_code&code=" + code);
            JSONObject jsonObject = JSONObject.parseObject(accessTokenString);

            accessToken = jsonObject.getString("access_token");
            openid = jsonObject.getString("openid");

            httpSession.setAttribute("accessToken", accessToken);
            httpSession.setAttribute("openid", openid);

            System.out.println("accessToken方法进来了=============");
            try {
                Timer timer = new Timer();
                //TimerTask实现5分钟后从session中删除checkCode
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String accessTokenf = (String) httpSession.getAttribute("accessToken");

                        String accessTokenString1 = httpUtils.sendGet("https://api.weixin.qq.com/sns/oauth2/refresh_token", "appid=" + APPID + "&grant_type=refresh_token&refresh_token=" + accessTokenf);
                        JSONObject jsonObject = JSONObject.parseObject(accessTokenString1);
                        String accessToken1 = jsonObject.getString("refresh_token");
                        String openid1 = jsonObject.getString("openid");

                        httpSession.setAttribute("accessToken", accessToken1);
                        httpSession.setAttribute("openid", openid1);

//                        httpSession.removeAttribute("accessToken");
                        System.out.println("accessToken删除成功=========accessToken删除成功");

                        timer.cancel();
                    }
                }, /*1000 * 7000*/600 * 5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            accessToken = (String) httpSession.getAttribute("accessToken");
            openid = (String) httpSession.getAttribute("openid");
        }
        System.out.println("accessToken=====" + accessToken + "openid=======" + openid);
        String userinfo = httpUtils.sendGet("https://api.weixin.qq.com/sns/userinfo", "lang=zh_CN&access_token=" + accessToken + "&openid=" + openid);
        System.out.println(userinfo.toString());
        System.out.println("--------------");
        System.out.println(userinfo);
        return Message.success(userinfo);
    }
}
