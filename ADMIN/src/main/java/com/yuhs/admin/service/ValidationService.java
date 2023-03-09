package com.yuhs.admin.service;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuhs.admin.json.ResponseJsonCodeTable;

/*
 * 
 * */
@Service
public class ValidationService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired AdminMemberService adminMemberService;
	
	public ResponseJsonCodeTable memberDataValidation(HashMap<Object, Object> param) throws Exception {
			
		if(!blankCheck((String)param.get("inputMemberId"))) {
			return ResponseJsonCodeTable.ERR_BLANK_CATNOT_ID;
		}else if(isStringEmpty((String)param.get("inputMemberId"))) {
			return ResponseJsonCodeTable.ERR_REQUIRED_MEMBER_ID;
		}else if(isStringEmpty((String)param.get("inputMemberName"))) {
			return ResponseJsonCodeTable.ERR_REQUIRED_MEMBER_NAME;
		}else if(isStringEmpty((String)param.get("inputPassword"))) {
			return ResponseJsonCodeTable.ERR_REQUIRED_PASSWORD;
		}else if(isStringEmpty((String)param.get("inputPasswordConfirm"))) {
			return ResponseJsonCodeTable.ERR_REQUIRED_PASSWORD_CONFIRM;
		}else if(isStringEmpty((String)param.get("inputEmail"))) {
			return ResponseJsonCodeTable.ERR_REQUIRED_EMAIL;
		}else if(isStringEmpty((String)param.get("inputMobileNumber"))) {
			return ResponseJsonCodeTable.ERR_REQUIRED_MOBILE_NUMBER;
		}
		
		int memberCount = adminMemberService.checkMemberCount(param);
		if(memberCount > 0) {
			return ResponseJsonCodeTable.ERR_MEMBER_ID_DUPLICATE;
		}else if(!isVaildPassword((String)param.get("inputPassword"))) {
			return ResponseJsonCodeTable.ERR_NOT_VAILD_PASSWORD;
		}else if(!comparePassword((String)param.get("inputPassword"),(String)param.get("inputPasswordConfirm"))) {
			return ResponseJsonCodeTable.ERR_NOT_VAILD_PASSWORD_CONFIRM;
		}else if(!isVaildEmail((String)param.get("inputEmail"))) {
			return ResponseJsonCodeTable.ERR_NOT_VAILD_EMAIL;
		}else if(!isVaildMobileNumber((String)param.get("inputMobileNumber"))) {
			return ResponseJsonCodeTable.ERR_NOT_VAILD_MOBILE_NUMBER;
		}else{
			return ResponseJsonCodeTable.MEMBER_VALIDATION_SUCCESS;
		}
	
	}

	private boolean blankCheck(String inputString){
		if(inputString.indexOf(" ") == -1) {//공백이 없으면
			return true;
		}
		return false;
	}
		
		private boolean isStringEmpty(String inputString){
		return inputString == null || inputString.isEmpty();
	}
	
	private boolean isVaildPassword(String password) {
		boolean result = false;
		if(password.length() > 7) {
			result = true;
		}
		return result;
	}
	
	private boolean comparePassword(String password, String passwordConfirm) {
		boolean result = false;
		if(password.equals(passwordConfirm)) {
			result = true;
		}
		return result;
	}

	private boolean isVaildEmail(String email) {
		boolean result = false;
		String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";   
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		if(m.matches()) {
			result = true; 
		}
		return result;
	}
	
	private boolean isVaildMobileNumber(String mobileNumber) {
		boolean result = false;
		String regex = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";   
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobileNumber);
		if(m.matches()) {
			result = true; 
		}
		return result;
	}
}
