package com.csx.cxy.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserEnum {

    BOY(0, "男"),
    GIRL(1, "女");

    @EnumValue
    private Integer code;

    @JsonValue
    private String label;

    UserEnum(Integer code, String label) {
        this.code = code;
        this.label = label;
    }

    public Integer getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
