package com.ruoyi.goods.base.enums;

public enum OperTypeEnum {

    ADD("ADD","新增"),
    UPDATE("UPDATE","修改"),
    DELETE("DELETE","删除"),
    QUERY("QUERY","查询");


    private String code;

    private String name;

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
