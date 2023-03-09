package com.yuhs.admin.mapper.admindb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AdminMenuMapper {

	List<Map<String, String>> getAllMenuList() throws Exception;

	void insertMenu(HashMap<Object, Object> param) throws Exception;

}
