package com.ruoyi.goods.app.service.impl;

import com.ruoyi.goods.app.service.GoodsAppService;
import org.springframework.stereotype.Service;

@Service
public class GoodsAppServiceImpl implements GoodsAppService {
    @Override
    public <T> T actionRequest() {

        return (T) "测试1";
    }
}
