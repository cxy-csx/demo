package com.csx.cxy.entity;

import com.csx.cxy.enums.UserEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.models.auth.In;
import lombok.Data;

import javax.smartcardio.ATR;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class User {

    private Integer id;

    private String name;


    private Integer age;


    private List<String> test;


    private Integer gender;


    private LocalDateTime createTime;

}
