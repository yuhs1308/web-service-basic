package com.yuhs.admin.controller.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuhs.admin.service.AdminMenuService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MenuController {

private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired AdminMenuService adminMenuService;
	
	@RequestMapping("/menu/list.do")
	public String menuList(HttpServletRequest request, ModelMap model) throws Exception {
		List<Map<String,String>> list = adminMenuService.getAllMenuList();
		model.addAttribute("menuList", list);
		return "menu/list";
	}
	
	@RequestMapping("/menu/regist.do")
	public String menuRegist(HttpServletRequest request) throws Exception {
		
		//menuReg
		return "menu/list";
	}
}
