package com.yuhs.admin.controller.main;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuhs.admin.service.AdminMemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired AdminMemberService adminMemberService;
	
	@RequestMapping("/main.do")
	public String main(HttpServletRequest request) throws Exception {
		log.info("/main.do");
		HttpSession session = request.getSession();
		Map<Object,Object> sessionMemberMap = (Map<Object, Object>) session.getAttribute("MEMBER");
		if(sessionMemberMap == null) {
			return "redirect:/login.do";	
		}
		
		log.info("SESSION MEMBER : " + sessionMemberMap.toString());
		return "main/main";
	}
	
	@RequestMapping("/layout/top.do")
	public String layoutTop(HttpServletRequest request) throws Exception {
		return "layout/top";
	}
	
	@RequestMapping("/layout/nav.do")
	public String layoutNavigation(HttpServletRequest request) throws Exception {
		return "layout/nav";
	}
	
	@RequestMapping("/layout/footer.do")
	public String layoutFooter(HttpServletRequest request) throws Exception {
		return "layout/footer";
	}
}
