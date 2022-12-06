package com.company.transfersystem.dto.response;

import java.io.Serializable;

public class BaseResponse<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public BaseResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public BaseResponse() {
    }


    public Integer getCode() {
        return code;
    }

    public BaseResponse<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public BaseResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<T>()
                .setCode(200)
                .setMessage("success")
                .setData(data);
    }
}
