package com.song.controller;

import com.song.pojo.User;
import com.song.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
public class ItemController {

    @Autowired
    private ItemServiceImpl itemServiceImpl;

    // ���ų����һ
    @RequestMapping(value = "/item/itemlist.action")
    public ModelAndView itemList() {
        //List<User> su = itemServiceImpl.selectUser();

        ModelAndView mav = new ModelAndView();
        // ����
//		mav.addObject("itemList", list);
        //mav.addObject("userList", su);
        mav.setViewName("WEB-INF/jsp/itemList");
        return mav;
    }

//    @RequestMapping(value="/item/itemlist.action")
//    public ModelAndView itemList1(@RequestParam(value = "id", defaultValue = "123456",required = false) Integer id, HttpServletRequest request) {
////    public ModelAndView itemList1(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model, Integer id) {
//
////        String Id = request.getParameter("id");
////        System.out.println(Id);
//        System.out.println(id);
//        ModelAndView mav = new ModelAndView();
//        return mav;
//    }

    @RequestMapping(value = "/item/addUser.action")
    public void insertItemList(User user) {
        itemServiceImpl.insertUser(user);
    }

    @RequestMapping(value = "/item/getUser.action")
    @ResponseBody
    public List<User> getUserList(Integer id, @ModelAttribute("user") User user, HttpServletRequest request, String a) {
        System.out.println(request);
        System.out.println(a);
        List<User> users;

        if (id != null) {
            users = itemServiceImpl.findUserByUser(user);
        } else {
            users = itemServiceImpl.findAllUser();
        }

        return users;
    }
}
