package com.ruoyi.goods.app.service.impl;

import com.ruoyi.goods.app.mapper.GoodsPlaceOrderMapper;
import com.ruoyi.goods.app.service.GoodsAppService;
import com.ruoyi.goods.base.enums.OrderStatusEnum;
import com.ruoyi.goods.domain.GoodsOrder;
import com.ruoyi.goods.manage.mapper.GoodsMessageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * CLASS_NAME
 * DESCRIPTION 商品下单退货实现
 * Date 2021/10/12 11:45
 * ModifyDate 2021/10/12 11:45
 * @Version 1.0
 */
@Service
public class GoodsOrderCancelImpl implements GoodsAppService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsOrderCancelImpl.class);

    @Autowired
    private GoodsPlaceOrderMapper goodsPlaceOrderMapper;

    @Autowired
    private GoodsMessageMapper goodsMessageMapper;

    /**
     * 下单请求
     * @param obj
     * @param <T>
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public <T> T actionRequest(Object obj) throws Exception {
        try {
            GoodsOrder goodsOrder = (GoodsOrder) obj;
           //修改订单状态，供管理端查询
            goodsOrder.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
            goodsPlaceOrderMapper.updateGoodsOrder(goodsOrder);
        } catch (Exception e) {
            LOGGER.info("[GoodsPlaceOrderImpl],退货失败，失败原因：{}", e.getMessage(), e);
            throw e;
        }
        return null;
    }
}
