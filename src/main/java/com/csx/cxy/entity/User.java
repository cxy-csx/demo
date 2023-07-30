package com.csx.cxy.entity;

import com.csx.cxy.enums.UserEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.smartcardio.ATR;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private UserEnum gender;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime createTime;

}
