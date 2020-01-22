package com.song.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.song.pojo.User;
import com.song.service.ItemServiceImpl;
import com.song.util.SimpleJsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class ItemController {

    @Autowired
    private ItemServiceImpl itemServiceImpl;

//    @Resource
//    private SimpleJsonResult simpleJsonResult;

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
    public Object getUserList(Integer id, @ModelAttribute("user") User user, HttpServletRequest request, String a) {

        System.out.println(request);
        System.out.println(a);
        List<User> userss;

        if (id != null) {
            userss = itemServiceImpl.findUserByUser(user);

//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.read
        } else {
            userss = itemServiceImpl.findAllUser();
        }
//        Object userss = new SimpleJsonResult(true, users);
//        Object userss = JSONArray.toJSON(users);
        return userss;
    }
}
