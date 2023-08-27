package com.app.exception.customexceptions;

@SuppressWarnings("serial")
public class CartNotFoundException extends RuntimeException{
	public CartNotFoundException(String mesg) {
		super(mesg);
	}
}
