package com.subway.exception;

import java.util.HashMap;

public class MyException extends RuntimeException{
    private Integer code;
    private String message;
    private HashMap hashMap;

    public MyException(Integer code, String message,HashMap hashMap) {
        this.code = code;
        this.message = message;
        this.hashMap = hashMap;
    }

    public MyException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public MyException() {

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HashMap getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }
}
