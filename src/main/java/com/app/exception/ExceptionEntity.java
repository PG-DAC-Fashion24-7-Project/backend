package com.app.exception;

import org.springframework.http.HttpStatus;

public class ExceptionEntity {
    private HttpStatus status;
    private String message;
    private Integer error;

    public ExceptionEntity(HttpStatus status, String message, Integer error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }
}
