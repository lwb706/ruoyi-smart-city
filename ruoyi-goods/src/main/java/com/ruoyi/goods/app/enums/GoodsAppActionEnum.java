package com.ruoyi.goods.app.enums;

import com.ruoyi.goods.app.constants.GoodsAppConstants;
import com.ruoyi.goods.domain.Goods;

/**
 * CLASS_NAME
 * DESCRIPTION 商品app请求Action枚举类
 * Date 2021/10/8 15:04
 * ModifyDate 2021/10/8 15:04
 * @Version 1.0
 */
public enum GoodsAppActionEnum {

    GOODS0001(GoodsAppConstants.GOODS0001, Object.class),
    GOODS0002(GoodsAppConstants.GOODS0002, Object.class);


    GoodsAppActionEnum(String code, Class domainClass) {
        this.code = code;
        this.domainClass = domainClass;
    }

    private String code;
    private Class domainClass;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Class getDomainClass() {
        return domainClass;
    }

    public void setDomainClass(Class domainClass) {
        this.domainClass = domainClass;
    }
}
