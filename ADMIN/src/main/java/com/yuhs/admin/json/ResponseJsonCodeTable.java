package com.yuhs.admin.json;

public enum ResponseJsonCodeTable {
	
	
	/*공통*/
	SUCCESS("ture","200","성공하였습니다."),
	ERROR_404("false","404","에러가 발생하였습니다."),
	ERROR_500("false","500","에러가 발생하였습니다."),
	/* 가입가능한 회원인지 체크 */
	MEMBER_VALIDATION_SUCCESS		("ture", "900","등록 가능한 아이디 입니다."),
	ERR_MEMBER_ID_DUPLICATE			("false","901","이미 가입된 아이디 입니다."),
	ERR_BLANK_CATNOT_ID				("false","902","아이디에 공백은 포함 할 수 없습니다."), 
	ERR_REQUIRED_MEMBER_ID			("false","903","아이디는 필수입니다."),
	ERR_REQUIRED_MEMBER_NAME		("false","904","이름은 필수입니다."),
	ERR_REQUIRED_PASSWORD			("false","905","패스워드는 필수입니다."), 
	ERR_REQUIRED_PASSWORD_CONFIRM	("false","906","패스워드확인은 필수입니다."),
	ERR_REQUIRED_EMAIL				("false","907","이메일은 필수입니다."),
	ERR_REQUIRED_MOBILE_NUMBER		("false","908","모바일번호는 필수입니다."),
	ERR_NOT_VAILD_PASSWORD			("false","909","패스워드는 8자리 이상입력하세요."),
	ERR_NOT_VAILD_PASSWORD_CONFIRM	("false","910","패스워드와 패스워드확인이 다릅니다."),
	ERR_NOT_VAILD_MOBILE_NUMBER		("false","911","핸드폰번호가 잘 못 되었습니다."),
	ERR_NOT_VAILD_EMAIL				("false","912","이메일주소가 잘 못 되었습니다."),
	
	
	ERR_FAIL_CREATE_MENU				("false","801","메뉴생성에 실패하였습니다."),
	;
	
	
	private String result;
	private String code;
	private String message;
	
	ResponseJsonCodeTable(String result, String code, String message){
		this.result = result;
		this.code = code;
		this.message = message;
	}

	public String getResult() {
		return result;
	}
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
