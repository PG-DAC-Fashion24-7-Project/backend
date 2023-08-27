package com.app.models.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;


public class GenerateResponseDto {
    private int responseCode;
    private String status;
    private String message;
    private Object data;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public GenerateResponseDto(int responseCode, String status, String message) {
        this.responseCode = responseCode;
        this.status = status;
        this.message = message;
    }

    public GenerateResponseDto(int responseCode, String status, Object data) {
        this.responseCode = responseCode;
        this.status = status;
        this.data = data;
    }

    //    public static ResponseEntity<?> success(Object data) {
//        Map<String, Object> map = new HashMap<>();
//
//        if(data != null){
//            map.put("status", "success");
//            map.put("data", data);
//            return ResponseEntity.ok(map);
//        }
//        map.put("status", "failed");
//        map.put("message", "record not found");
//        return ResponseEntity.ok(map);
//    }

//    public static ResponseEntity<?> error(Object err) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("status", "error");
//        if(err != null)
//            map.put("error", err);
//        return ResponseEntity.ok(map);
//    }
}
