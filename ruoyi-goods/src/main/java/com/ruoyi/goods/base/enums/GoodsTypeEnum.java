package com.ruoyi.goods.base.enums;

public enum GoodsTypeEnum {
    H("H", "主页置顶商品"),
    M("M", "信息商品列表");
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

    GoodsTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
