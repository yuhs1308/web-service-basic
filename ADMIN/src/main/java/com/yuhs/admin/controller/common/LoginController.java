package com.yuhs.admin.controller.common;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuhs.admin.service.AdminMemberService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired AdminMemberService adminMemberService;
	
	@RequestMapping("/index.do")
	public String index() throws Exception {
		log.info("index.do info");
		return "index";
	}
	
	@RequestMapping("/login.do")
	public String login() throws Exception {
		log.info("login.do info");
		return "login/login";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) throws Exception {
		request.getSession().invalidate();
		return "redirect:/login.do";
	}
	
	
	@RequestMapping("/login/process.do")
	public String loginProcesss(HttpServletRequest request, @RequestParam HashMap<Object, Object> param, ModelMap model) throws Exception {
		log.info("/login/process.do :");
		log.debug("login.do debug");
		if(adminMemberService.loginProcess(request, param)) {//로그인 성공
			return "redirect:/main.do";
		}else {//로그인 실패
			model.addAttribute("inputId", param.get("inputId"));
			model.addAttribute("inputPassword", param.get("inputPassword"));
			model.addAttribute("errorMessage", "로그인에 실패하였습니다.");
			String referer = request.getHeader("Referer");
			return "login/login";
		}
	}
}
