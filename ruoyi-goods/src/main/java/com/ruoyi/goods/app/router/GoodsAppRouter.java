package com.ruoyi.goods.app.router;

import com.ruoyi.goods.app.constants.GoodsAppConstants;
import com.ruoyi.goods.app.service.GoodsAppService;
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
public class GoodsAppRouter {

    private enum StepType {
        GOODS0001(GoodsAppConstants.GOODS0001, "goodsAppServiceImpl"),
        GOODS0005(GoodsAppConstants.GOODS0005, "noticesAppServiceImpl"),
        GOODS0006(GoodsAppConstants.GOODS0006, "commentAppServiceImp");


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
    Map<String, GoodsAppService> appMap;

    public GoodsAppService getGoodsAppService(String type){
        return appMap.get(StepType.valueOf(type).getServiceName());
    }
}
