package com.app.exception.customexceptions;

@SuppressWarnings("serial")
public class CategoryNotFoundException extends RuntimeException{
	public CategoryNotFoundException(String errMesg) {
		super(errMesg);
	}
}
