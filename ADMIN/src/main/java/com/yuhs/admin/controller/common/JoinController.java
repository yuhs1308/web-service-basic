package com.yuhs.admin.controller.common;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuhs.admin.service.AdminMemberService;
import com.yuhs.admin.support.DataMap;
import com.yuhs.admin.util.EncriptionUtil;

@Controller
public class JoinController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired AdminMemberService adminMemberService;
	
	@RequestMapping("/join.do")
	public String joinForm() throws Exception {
		log.debug("[/join.do-START]");
		log.debug("[/join.do-END]");
		return "join/form";
	}
	
	@RequestMapping("/join/process.do")
	public String joinProcess(@RequestParam HashMap<Object, Object> param, ModelMap modelMap) throws Exception {
		log.info("[/join/prcess.do-START]");
		log.debug("REQUEST PARAM : "+param.toString());
		param.put("shaPassword", EncriptionUtil.getSHA512((String)param.get("inputPassword")));
		
		adminMemberService.registMember(param);

		return "join/process";
	}
}
