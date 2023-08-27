package com.app.exception.customexceptions;

public class OrderItemNotFoundException extends RuntimeException{
    public OrderItemNotFoundException(String msg) {
        super(msg);
    }
}
