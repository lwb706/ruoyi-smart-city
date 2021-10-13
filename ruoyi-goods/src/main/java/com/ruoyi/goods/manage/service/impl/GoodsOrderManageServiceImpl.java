package com.ruoyi.goods.manage.service.impl;

import com.ruoyi.goods.app.mapper.GoodsPlaceOrderMapper;
import com.ruoyi.goods.base.enums.OperTypeEnum;
import com.ruoyi.goods.base.enums.OrderStatusEnum;
import com.ruoyi.goods.domain.GoodsOrder;
import com.ruoyi.goods.manage.mapper.GoodsMessageMapper;
import com.ruoyi.goods.manage.service.GoodsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * CLASS_NAME
 * DESCRIPTION 商品订单退货接口实现
 * Date 2021/10/9 15:25
 * ModifyDate 2021/10/9 15:25
 * @Version 1.0
 */
@Service
public class GoodsOrderManageServiceImpl implements GoodsManageService {

    @Autowired
    private GoodsPlaceOrderMapper goodsPlaceOrderMapper;

    @Autowired
    private GoodsMessageMapper goodsMessageMapper;

    @Override
    public <T> T actionRequest(Object obj,String operType) {
        switch (OperTypeEnum.getOperTypeEnum(operType)) {
            case UPDATE:
                updateGoods(obj);
                break;
            case QUERY:
                return (T) queryGoodsOrderList(obj);
            default:
                break;
        }
        return null;
    }

    /**
     * 修改订单信息
     * @param obj
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    private void updateGoods(Object obj){
        //1、修改订单信息
        GoodsOrder goodsOrder = (GoodsOrder) obj;
        goodsOrder.setOrderStatus(OrderStatusEnum.RETURNED.getCode());
        goodsPlaceOrderMapper.updateGoodsOrder(goodsOrder);
        //2、调取微信接口进行退款操作
        //TODO

        //3、退款成功后把量进行还原操作（待确定）

    }

    /**
     * 查询商品信息列表
     * @param obj
     * @return
     */
    private List<GoodsOrder> queryGoodsOrderList(Object obj){
        GoodsOrder goodsOrder = (GoodsOrder) obj;
        List<GoodsOrder> goodsOrderList = goodsPlaceOrderMapper.queryGoodsOrderList(goodsOrder);
        return goodsOrderList;
    }
}
