package com.ruoyi.goods.base.enums;

import java.util.HashMap;
import java.util.Map;

public enum OperTypeEnum {

    ADD("ADD","新增"),
    UPDATE("UPDATE","修改"),
    DELETE("DELETE","删除"),
    QUERY("QUERY","查询");


    private String code;

    private String name;

    private static Map<String, OperTypeEnum> OPERMAP = new HashMap<>();

    static {
        for(OperTypeEnum operTypeEnum : values()){
            OPERMAP.put(operTypeEnum.code, operTypeEnum);
        }
    }

    public static OperTypeEnum getOperTypeEnum(String code){
        return OPERMAP.get(code);
    }

    OperTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
