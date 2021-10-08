package com.ruoyi.goods.app.router;

import com.ruoyi.goods.app.constants.GoodsAppConstants;
import com.ruoyi.goods.app.service.GoodsAppService;
import com.ruoyi.goods.app.service.impl.GoodsAppServiceImpl;
import com.ruoyi.goods.app.service.impl.Test2ServiceImpl;
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
        GOODS0002(GoodsAppConstants.GOODS0002, "test2ServiceImpl");

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
