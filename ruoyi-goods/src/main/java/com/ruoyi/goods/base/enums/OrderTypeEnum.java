package com.ruoyi.goods.base.enums;

public enum OrderTypeEnum {
    GOODS("G", "商品"),
    TICKET("T", "已退货");
    private String code;
    private String name;

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

    OrderTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
