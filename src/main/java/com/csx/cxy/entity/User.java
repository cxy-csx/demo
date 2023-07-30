package com.csx.cxy.entity;

import com.csx.cxy.enums.UserEnum;
import lombok.Data;

import javax.smartcardio.ATR;

@Data
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private UserEnum gender;
}
