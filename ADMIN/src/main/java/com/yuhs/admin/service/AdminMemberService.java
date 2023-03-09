package com.yuhs.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuhs.admin.mapper.admindb.AdminMemberMapper;
import com.yuhs.admin.mapper.systemdb.SystemMemberMapper;
import com.yuhs.admin.mapper.userdb.MemberMapper;
import com.yuhs.admin.util.EncriptionUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class AdminMemberService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired	AdminMemberMapper adminMemberMapper;
	@Autowired	MemberMapper memberMapper;
	@Autowired	SystemMemberMapper systemMemberMapper;
	
	public String getMembers() throws Exception{
	
		return "ok";
	}

	public void registMember(HashMap<Object, Object> param) throws Exception{
		adminMemberMapper.insertMember(param);
	}

	public int checkMemberCount(HashMap<Object, Object> param) throws Exception{
		return adminMemberMapper.checkMemberCount(param);
	}


	public boolean loginProcess(HttpServletRequest request, HashMap<Object, Object> param) throws Exception{
		param.put("shaPassword", EncriptionUtil.getSHA512((String)param.get("inputPassword")));
		log.info("login process param : " + param.toString());
		Map<String,String> member = adminMemberMapper.getAdminMember(param);
		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("MEMBER", member);
			session.setAttribute("PERMISSTION_LIST", "");
			return true;
		}else {
			return false;
		}
	}

}
