package com.yuhs.admin.support;

public enum CodeTable123123 {
	SUCCESS("ture","200","성공하였습니다."),
	ERROR_404("false","404","에러가 발생하였습니다."),
	ERROR_500("false","500","에러가 발생하였습니다.");
	
	private String result;
	private String code;
	private String message;
	
	CodeTable123123(String result, String code, String message){
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
