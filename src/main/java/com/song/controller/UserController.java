package com.song.controller;

import com.song.pojo.User;
import com.song.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    // 查询用户
    @RequestMapping(value = "/item/userLogin.action")
    @ResponseBody
    public Object userLoginRes(Integer id, @ModelAttribute("user") User user, String username, String password, HttpServletRequest httpServletRequest, MultipartFile file) throws IOException {//,@RequestBody User users_
        if (username != null && password != null) {
            return new SimpleJsonResult(true, userServiceImpl.findUserByUser(user));
        } else {
            return new SimpleJsonResult(
                    false,
                    StringUtils.isEmpty(username) && StringUtils.isEmpty(password) ? "用户名与密码不存在" : StringUtils.isEmpty(username) ? "用户名为空" : StringUtils.isEmpty(password) ? "用户名为空" : ""
            );
        }
    }

    @RequestMapping(value = "/item/userRegister.action")
    @ResponseBody
    public Object userRegister(Integer id, @ModelAttribute("user") User user, String username, String password, String nickName, String QQPicURL, String openid) {
        System.out.println("ewqrw");
        if ((username != null && password != null) || (nickName != null && QQPicURL != null && openid != null)) {
            int size = userServiceImpl.findUserByUser(user).size();
            System.out.println("++++++++++++++=======================");
            System.out.println(size);
            if (size == 0) {
                user.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
                String insertVar = userServiceImpl.insertUserByUser(user);
                if (insertVar.equals("SUCCESS")) {
                    return new SimpleJsonResult(true, userServiceImpl.findUserByUser(user));
                }
            } else {
                return new SimpleJsonResult(false, "用户已存在，禁止注册");
            }

        } else {
            return new SimpleJsonResult(
                    false,
                    StringUtils.isEmpty(username) && StringUtils.isEmpty(password) ? "用户名与密码不存在" : StringUtils.isEmpty(username) ? "用户名为空" : StringUtils.isEmpty(password) ? "用户名为空" : ""
            );
        }
        return null;
    }

    @RequestMapping(value = "/item/qqLogin.action")
    @ResponseBody
    public Object QQLogin(@ModelAttribute("user") User user1) {
        Object o = null;
        int size = userServiceImpl.findUserByUser(user1).size();
        if (size == 0) {
            user1.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
            userServiceImpl.insertUserByUser(user1);
        }
        o = userServiceImpl.findUserByUser(user1);
        return o;
    }
}
