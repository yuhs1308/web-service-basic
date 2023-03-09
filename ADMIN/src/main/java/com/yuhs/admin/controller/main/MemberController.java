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
public class MemberController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired AdminMemberService adminMemberService;
	
	@RequestMapping("/member/info.do")
	public String main(HttpServletRequest request) throws Exception {
		
		return "member/info";
	}
	
	
}
