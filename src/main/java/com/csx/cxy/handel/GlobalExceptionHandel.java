package com.csx.cxy.handel;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandel {

    @ExceptionHandler(Exception.class)
    public String handel(Exception e){
        e.printStackTrace();
        return "服务器异常";
    }

}
