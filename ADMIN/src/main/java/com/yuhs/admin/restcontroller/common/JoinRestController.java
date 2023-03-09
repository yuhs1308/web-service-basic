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
import com.yuhs.admin.service.ValidationService;

@RestController
public class JoinRestController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired AdminMemberService adminMemberService;
	@Autowired ValidationService validationService;
	
	@ResponseBody
	@RequestMapping("/api/join/member/validation.do")
	public String joinProcess(@RequestParam HashMap<Object, Object> param) throws Exception {
		log.debug("[/join/prcess.do-START]");
		log.debug("REQUEST PARAM : "+param.toString());
		Map<Object, Object> jsonBodyData = new HashMap<Object, Object>();
		
		ResponseJsonCodeTable code = validationService.memberDataValidation(param);
		
		return new ResponseJsonBody(code, jsonBodyData).getBodyString();
	}
}
