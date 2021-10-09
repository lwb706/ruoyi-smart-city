package com.ruoyi.goods.app.service.impl;

import com.ruoyi.goods.app.service.GoodsAppService;
import com.ruoyi.goods.domain.Goods;
import org.springframework.stereotype.Service;

@Service
public class GoodsAppServiceImpl implements GoodsAppService {
    @Override
    public <T> T actionRequest(Object obj) {

        Goods goods = (Goods) obj;
        System.out.println("获取到的对象为：" + goods);
        return (T) "测试1";
    }
}
