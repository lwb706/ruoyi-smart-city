package com.ruoyi.goods.app.service.impl;

import com.ruoyi.goods.app.mapper.GoodsPlaceOrderMapper;
import com.ruoyi.goods.app.service.GoodsAppService;
import com.ruoyi.goods.base.util.ImgUtil;
import com.ruoyi.goods.domain.GoodsOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoodsOrderQueryImpl implements GoodsAppService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsOrderQueryImpl.class);

    @Autowired
    private GoodsPlaceOrderMapper goodsPlaceOrderMapper;
    /**
     * 商品订单查询操作
     * @param obj
     * @param <T>
     * @return
     * @throws Exception
     */
    @Override
    public <T> T actionRequest(Object obj) throws Exception {
        GoodsOrder goodsOrder = (GoodsOrder) obj;
        Map<String, Object> map = new HashMap<>();
        map.put("pageStart", goodsOrder.getPageStart());
        map.put("pageLimit", goodsOrder.getPageLimit());
        goodsOrder.setPageStart(ImgUtil.getStart(goodsOrder.getPageStart(), goodsOrder.getPageLimit()));
        map.put("total", goodsPlaceOrderMapper.queryGoodsOrderCount(goodsOrder));
        map.put("list", goodsPlaceOrderMapper.queryGoodsOrderList(goodsOrder));
        return (T) map;
    }
}
