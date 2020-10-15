package com.eesteche.demo.errors;

public class ErrorHandler extends RuntimeException {

	public ErrorHandler(String error) {
        super(error);
    }
}
