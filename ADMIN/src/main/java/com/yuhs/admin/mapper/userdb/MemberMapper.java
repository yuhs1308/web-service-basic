package com.yuhs.admin.mapper.userdb;

import java.util.List;
import java.util.Map;

public interface MemberMapper {
	public Map<String,String> getUser();
	
	public List<Map<String,String>> getAllUsers();
}
