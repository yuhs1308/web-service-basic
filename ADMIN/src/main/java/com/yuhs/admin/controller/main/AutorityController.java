package com.yuhs.admin.controller.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

public class AutorityController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	
	@RequestMapping("/autority/list.do")
	public String main(HttpServletRequest request) throws Exception {
		
		return "autority/list";
	}

}
