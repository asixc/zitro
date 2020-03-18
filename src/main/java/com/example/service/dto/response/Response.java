package com.example.service.dto.response;

import org.springframework.stereotype.Component;

@Component
public class Response {
	
	private String result;
	
	public void setResult(String result) {
		this.result = result;
	}

	public String getResult(){
		return result;
	}
}
