package com.example.exception;

import lombok.Getter;

@Getter
public class BusinessReservationException extends RuntimeException {
	
	@Getter
	private ExceptionCode exceptionCode;
	
	public BusinessReservationException(ExceptionCode exceptionCode) {
		super(exceptionCode.getMessage());
		this.exceptionCode = exceptionCode;
	}
}
