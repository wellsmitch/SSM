package com.song.controller;

import com.song.pojo.User;
import com.song.service.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ItemController {

	@Autowired
	private ItemServiceImpl itemServiceImpl;

	// ���ų����һ
	@RequestMapping(value="/item/itemlist.action")
	public ModelAndView itemList() {
		List<User> su = itemServiceImpl.selectUser();

		ModelAndView mav = new ModelAndView();
		// ����
//		mav.addObject("itemList", list);
		mav.addObject("userList", su);
		mav.setViewName("WEB-INF/jsp/itemList");
		return mav;
	}
}
