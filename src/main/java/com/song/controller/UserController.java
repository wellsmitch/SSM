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
import java.io.InputStream;
import java.util.List;

@Controller
public class UserController {

    @Autowired UserServiceImpl userServiceImpl;

    // 查询用户
    @RequestMapping(value = "/item/userLogin.action")
    @ResponseBody
    public Object userLoginRes(Integer id, @ModelAttribute("user") User user, String username, Integer password, HttpServletRequest httpServletRequest,MultipartFile file) throws IOException {//,@RequestBody User users_
//        System.out.println(users_);
        System.out.println(httpServletRequest);
        String s1 = httpServletRequest.getParameter("username");
        String txg = new String(file.getBytes());
        System.out.println(s1);
        System.out.println(txg);
        System.out.println("------------------");
        if (username != null && password!= null) {
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
    public Object userRegister(Integer id, @ModelAttribute("user") User user, String username, String password) {
        if (username != null && password!= null) {
            return new SimpleJsonResult(true, userServiceImpl.insertUserByUser(user));
        } else {
            return new SimpleJsonResult(
                    false,
                    StringUtils.isEmpty(username) && StringUtils.isEmpty(password) ? "用户名与密码不存在" : StringUtils.isEmpty(username) ? "用户名为空" : StringUtils.isEmpty(password) ? "用户名为空" : ""
            );
        }
    }
}
