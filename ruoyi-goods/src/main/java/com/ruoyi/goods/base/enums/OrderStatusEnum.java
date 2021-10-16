package com.ruoyi.goods.base.enums;

public enum OrderStatusEnum {
    UNPAID("U", "未支付"),
    PAID("P", "已支付"),
    CANCEL("C", "退货中"),
    RETURNED("R", "已退货");
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

    OrderStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
