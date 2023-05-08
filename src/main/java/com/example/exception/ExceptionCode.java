package com.example.exception;

import lombok.Getter;

public enum ExceptionCode {
	FAILED_TO_RESERVATION(405, "FAILED_TO_RESERVATION");
	@Getter
	private int status;
	@Getter
	private String message;
	
	ExceptionCode(int status, String message) {
		this.status = status;
		this.message = message;
	}
}
