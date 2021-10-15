package com.ruoyi.goods.manage.router;

import com.ruoyi.goods.manage.constants.GoodsManageConstants;
import com.ruoyi.goods.manage.service.GoodsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * CLASS_NAME
 * DESCRIPTION 动态路由
 * Date 2021/10/8 16:21
 * ModifyDate 2021/10/8 16:21
 * @Version 1.0
 */
@Service
public class GoodsManageRouter {

    private enum StepType {
        GOODS0022(GoodsManageConstants.GOODS0022,"goodsManageServiceImpl"),
        GOODS0023(GoodsManageConstants.GOODS0023,"goodsManageServiceImpl"),
        GOODS0024(GoodsManageConstants.GOODS0024,"goodsManageServiceImpl"),
        GOODS0025(GoodsManageConstants.GOODS0025, "goodsManageServiceImpl"),
        GOODS0026(GoodsManageConstants.GOODS0026, "goodsManageServiceImpl"),
        GOODS0027(GoodsManageConstants.GOODS0027, "goodsOrderManageServiceImpl"),
        GOODS0028(GoodsManageConstants.GOODS0028, "goodsOrderManageServiceImpl");

        //接口编码
        private String tranceCode;

        //路由接口实现类的名称
        private String serviceName;

        StepType(String tranceCode, String serviceName) {
            this.tranceCode = tranceCode;
            this.serviceName = serviceName;
        }
        public String getServiceName() {
            return serviceName;
        }
    }

    @Autowired
    Map<String, GoodsManageService> appMap;

    public GoodsManageService getGoodsManageService(String type){
        return appMap.get(StepType.valueOf(type).getServiceName());
    }

}
