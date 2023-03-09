package com.yuhs.admin.json;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/*
 * JSON BODY TABLE을 사용하여 API의 response body를 만들어준다
 * 규격은 ResponseJsonCodeTable enum  참고 
 * map으로 넘어돈 data는 json으로 변환됨
 * */
public class ResponseJsonBody{
	
	private Map<String, Object> resultMap = new HashMap<String,Object>();
	
	public ResponseJsonBody(ResponseJsonCodeTable codeText, Map<Object, Object> data) {
		ResponseJsonCodeTable codeTable = codeText;
		resultMap.put("result", codeTable.getResult());
		resultMap.put("message", codeTable.getMessage());
		resultMap.put("data", data);
		resultMap.put("code", codeTable.getCode());
	}

	public String getBodyString() {
		Gson gson = new Gson();
		return gson.toJson(resultMap);
	}

	
}
