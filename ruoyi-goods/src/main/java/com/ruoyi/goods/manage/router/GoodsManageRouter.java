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
        GOODS0017(GoodsManageConstants.GOODS0017, "newsManageServiceImpl"),
        GOODS0018(GoodsManageConstants.GOODS0018, "newsManageServiceImpl"),
        GOODS0019(GoodsManageConstants.GOODS0019, "newsManageServiceImpl"),
        GOODS0020(GoodsManageConstants.GOODS0020, "newsManageServiceImpl"),
        GOODS0021(GoodsManageConstants.GOODS0021, "newsManageServiceImpl"),
        GOODS0022(GoodsManageConstants.GOODS0022,"goodsManageServiceImpl"),
        GOODS0023(GoodsManageConstants.GOODS0023,"goodsManageServiceImpl"),
        GOODS0024(GoodsManageConstants.GOODS0024,"goodsManageServiceImpl"),
        GOODS0025(GoodsManageConstants.GOODS0025, "goodsManageServiceImpl"),
        GOODS0026(GoodsManageConstants.GOODS0026, "goodsManageServiceImpl"),
        GOODS0027(GoodsManageConstants.GOODS0027, "goodsOrderManageServiceImpl"),
        GOODS0028(GoodsManageConstants.GOODS0028, "goodsOrderManageServiceImpl"),
        GOODS0032(GoodsManageConstants.GOODS0032, "richContentManageServiceImpl"),
        GOODS0033(GoodsManageConstants.GOODS0033, "richContentManageServiceImpl"),
        GOODS0034(GoodsManageConstants.GOODS0034, "richContentManageServiceImpl"),
        GOODS0035(GoodsManageConstants.GOODS0035, "richContentManageServiceImpl");
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
