package com.yuhs.admin.restcontroller.common;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yuhs.admin.json.ResponseJsonBody;
import com.yuhs.admin.json.ResponseJsonCodeTable;
import com.yuhs.admin.service.AdminMemberService;
import com.yuhs.admin.service.AdminMenuService;

@RestController
public class MenuRestController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired AdminMenuService adminMenuService;
	
	@ResponseBody
	@RequestMapping("/api/menu/regist.do")
	public String menuRegist(@RequestParam HashMap<Object, Object> param) throws Exception {
		log.debug("[/api/menu/regist.do] REQUEST PARAM : "+param.toString());
		Map<Object, Object> jsonBodyData = new HashMap<Object, Object>();
		
		ResponseJsonCodeTable code = adminMenuService.menuRegist(param);
		
		return new ResponseJsonBody(code, jsonBodyData).getBodyString();
	}
}
