package com.xc.Exception;

public class StudentCastException extends Exception {

	public StudentCastException() {
	}

	public StudentCastException(String message) {
		super(message);
	}

	public StudentCastException(Throwable cause) {
		super(cause);
	}

	public StudentCastException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentCastException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
