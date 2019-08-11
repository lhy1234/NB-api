package com.nb3.exception;

/**
 * 业务异常
 */
public class BusinessException extends RuntimeException {

    private int code;

    private String msg;



    public BusinessException(int code,String message) {
        this.code = code;
        this.msg = message;
    }
}
