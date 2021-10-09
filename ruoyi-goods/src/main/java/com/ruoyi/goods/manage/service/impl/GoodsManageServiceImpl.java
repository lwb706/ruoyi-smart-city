package com.ruoyi.goods.manage.service.impl;

import com.ruoyi.goods.domain.Goods;
import com.ruoyi.goods.manage.service.GoodsManageService;
import org.springframework.stereotype.Service;

/**
 * CLASS_NAME
 * DESCRIPTION 商品新增接口实现
 * Date 2021/10/9 15:25
 * ModifyDate 2021/10/9 15:25
 * @Version 1.0
 */
@Service
public class GoodsManageServiceImpl implements GoodsManageService {
    @Override
    public <T> T actionRequest(Object obj,String operType) {
        //TODO 根据操作类型进入到不同的实现里面，增、删、改、查可以共用一个实现类
        Goods goods = (Goods) obj;
        System.out.println("获取到的对象为：" + goods);
        return (T) goods;
    }
}
