package com.example.demo.Common;

public enum StatusCode {
    SUCCESS(200, "成功"),
    VALIDATION_ERROR(400, "参数校验错误"),
    SERVER_ERROR(500, "服务器异常");

    private final int code;
    private final String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
