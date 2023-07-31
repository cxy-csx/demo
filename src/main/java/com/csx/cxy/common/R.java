package com.csx.cxy.common;

import com.csx.cxy.enums.ResultCode;
import lombok.Data;

public class R<T> {

    // 操作代码
    Integer code;

    // 提示信息
    String message;

    // 数据
    T data;

    public R() {
    }

    public R(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public R(ResultCode resultCode, T data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public R(String message) {
        this.message = message;
    }

    public static R SUCCESS() {
        return new R(ResultCode.SUCCESS);
    }

    public static <T> R SUCCESS(T data) {
        return new R(ResultCode.SUCCESS, data);
    }

    public static R FAIL() {
        return new R(ResultCode.FAIL);
    }

    public static R FAIL(String message) {
        return new R(ResultCode.FAIL, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
