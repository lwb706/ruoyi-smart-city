package com.ruoyi.goods.manage.enums;

import com.ruoyi.goods.base.enums.OperTypeEnum;
import com.ruoyi.goods.domain.Goods;
import com.ruoyi.goods.domain.GoodsOrder;
import com.ruoyi.goods.manage.constants.GoodsManageConstants;

/**
 * CLASS_NAME
 * DESCRIPTION 商品app请求Action枚举类
 * Date 2021/10/8 15:04
 * ModifyDate 2021/10/8 15:04
 * @Version 1.0
 */
public enum GoodsManageActionEnum {
    GOODS0022(GoodsManageConstants.GOODS0022, Goods.class, OperTypeEnum.DELETE.getCode()),
    GOODS0023(GoodsManageConstants.GOODS0023, Goods.class, OperTypeEnum.ADD.getCode()),
    GOODS0024(GoodsManageConstants.GOODS0024, Goods.class, OperTypeEnum.QUERY.getCode()),
    GOODS0025(GoodsManageConstants.GOODS0025, Goods.class, OperTypeEnum.UPDATE.getCode()),
    GOODS0026(GoodsManageConstants.GOODS0026, Goods.class, OperTypeEnum.QUERY.getCode()),
    GOODS0027(GoodsManageConstants.GOODS0027, GoodsOrder.class, OperTypeEnum.QUERY.getCode()),
    GOODS0028(GoodsManageConstants.GOODS0028, GoodsOrder.class, OperTypeEnum.UPDATE.getCode());


    GoodsManageActionEnum(String code, Class domainClass, String operType) {
        this.code = code;
        this.domainClass = domainClass;
        this.operType = operType;
    }

    //接口编码
    private String code;
    //接口请求转换实体类
    private Class domainClass;
    //操作类型
    private String operType;

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

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }
}
