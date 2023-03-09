package com.yuhs.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuhs.admin.json.ResponseJsonCodeTable;
import com.yuhs.admin.mapper.admindb.AdminMenuMapper;

@Service
public class AdminMenuService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired AdminMenuMapper adminMenuMapper;
	
	public List<Map<String, String>> getAllMenuList() throws Exception{
		return adminMenuMapper.getAllMenuList();
	}

	public ResponseJsonCodeTable menuRegist(HashMap<Object, Object> param) {
		try {
			adminMenuMapper.insertMenu(param);
			return ResponseJsonCodeTable.SUCCESS;
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseJsonCodeTable.ERR_FAIL_CREATE_MENU;
		}
	}
	
	
}
