package com.devlpjruan.desafio3devsup.dto;

public class FieldMessage {
	private String filedName;
	private String message;
	
	
	public FieldMessage(String filedName, String message) {
		this.filedName = filedName;
		this.message = message;
	}
	public String getFiledName() {
		return filedName;
	}
	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}	
