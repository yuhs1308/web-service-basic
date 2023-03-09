package com.yuhs.admin.mapper.admindb;

import java.util.HashMap;
import java.util.Map;


public interface AdminMemberMapper {
	public Map<String,String> getAdminMember(HashMap<Object, Object> param) throws Exception;

	public void insertMember(HashMap<Object, Object> param) throws Exception;

	public int checkMemberCount(HashMap<Object, Object> param) throws Exception;

}
