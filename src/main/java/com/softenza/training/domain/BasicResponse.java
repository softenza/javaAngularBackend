package com.softenza.training.domain;

public class BasicResponse {
	private String error;

	public BasicResponse(String error) {
		this.error = error;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
