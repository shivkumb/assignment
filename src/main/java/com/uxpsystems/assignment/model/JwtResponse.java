package com.uxpsystems.assignment.model;

import org.springframework.stereotype.Component;

@Component
public class JwtResponse {

	private String token;
	
	
	public JwtResponse() {
		
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public JwtResponse(String token) {
		super();
		this.token = token;
	}

}
