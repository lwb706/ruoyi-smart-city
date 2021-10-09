package com.ruoyi.goods.app.service.impl;

import com.ruoyi.goods.app.service.GoodsAppService;
import org.springframework.stereotype.Service;

@Service
public class Test2ServiceImpl implements GoodsAppService {
    @Override
    public <T> T actionRequest(Object obj) {

        return (T) "测试2";
    }
}
