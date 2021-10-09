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
    public <T> T actionRequest(Object obj) {

        Goods goods = (Goods) obj;
        System.out.println("获取到的对象为：" + goods);
        return (T) goods;
    }
}
