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
        GOODS0023(GoodsManageConstants.GOODS0023, "goodsAppServiceImpl");

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
