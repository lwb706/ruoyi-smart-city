package com.ruoyi.goods.app.enums;

import com.ruoyi.goods.app.constants.GoodsAppConstants;
import com.ruoyi.goods.domain.CommentNews;
import com.ruoyi.goods.domain.Goods;
import com.ruoyi.goods.domain.GoodsOrder;
import com.ruoyi.goods.domain.NoticeParam;

/**
 * CLASS_NAME
 * DESCRIPTION 商品app请求Action枚举类
 * Date 2021/10/8 15:04
 * ModifyDate 2021/10/8 15:04
 * @Version 1.0
 */
public enum GoodsAppActionEnum {
    GOODS0001(GoodsAppConstants.GOODS0001, Object.class),
    GOODS0002(GoodsAppConstants.GOODS0002, Object.class),
    GOODS0004(GoodsAppConstants.GOODS0004, NoticeParam.class),
    GOODS0005(GoodsAppConstants.GOODS0005, NoticeParam.class),
    GOODS0006(GoodsAppConstants.GOODS0006, CommentNews.class),
    GOODS0010(GoodsAppConstants.GOODS0010, Goods.class),
    GOODS0011(GoodsAppConstants.GOODS0011, GoodsOrder.class),
    GOODS0012(GoodsAppConstants.GOODS0012, GoodsOrder.class),
    GOODS0015(GoodsAppConstants.GOODS0015, GoodsOrder.class);

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
