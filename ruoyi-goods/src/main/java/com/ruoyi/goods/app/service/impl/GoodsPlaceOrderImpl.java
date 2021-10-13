package com.ruoyi.goods.app.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.goods.app.mapper.GoodsPlaceOrderMapper;
import com.ruoyi.goods.app.service.GoodsAppService;
import com.ruoyi.goods.base.enums.OrderStatusEnum;
import com.ruoyi.goods.domain.Goods;
import com.ruoyi.goods.domain.GoodsOrder;
import com.ruoyi.goods.manage.mapper.GoodsMessageMapper;
import com.sun.xml.internal.bind.v2.TODO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * CLASS_NAME
 * DESCRIPTION 商品下单实现
 * Date 2021/10/12 11:45
 * ModifyDate 2021/10/12 11:45
 * @Version 1.0
 */
public class GoodsPlaceOrderImpl implements GoodsAppService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsPlaceOrderImpl.class);

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
            //插入订单到数据库
            addGoodsOrder(goodsOrder);
            //进行商品剩余量的扣减
            cutGoodsNum(goodsOrder);
            //调取微信扣减金额操作

        } catch (Exception e) {
            LOGGER.info("[GoodsPlaceOrderImpl],下单失败，失败原因：{}", e.getMessage(), e);
            throw e;
        }
        return null;
    }

    /**
     * 下单操作
     */
    private void addGoodsOrder(GoodsOrder goodsOrder){
        //生成唯一ID
        goodsOrder.setId(IdUtils.fastSimpleUUID());
        //未支付状态
        goodsOrder.setOrderStatus(OrderStatusEnum.UNPAID.getCode());
        goodsPlaceOrderMapper.insertGoodsOrder(goodsOrder);
    }

    /**
     * 修改商量卖出数量
     * @param goodsOrder
     * @throws Exception
     */
    private void cutGoodsNum(GoodsOrder goodsOrder) throws Exception {
        Goods goods = new Goods();
        goods.setId(goodsOrder.getCommodityId());
        List<Goods> goodsList = goodsMessageMapper.queryGoodsList(goods);
        if(goodsList.size() > 0){
            int sell = Math.addExact(goodsList.get(0).getSell(), goodsOrder.getSum());
            if(sell > goodsList.get(0).getNum()){
                throw new Exception("下单数量超过商品剩余数量");
            }
            goods.setSell(sell);
            goodsMessageMapper.updateGoods(goods);
        }

    }

    /**
     * 修改订单信息
     * @param goodsOrder
     */
    private void updateGoodsOrder(GoodsOrder goodsOrder){
        goodsPlaceOrderMapper.updateGoodsOrder(goodsOrder);
    }

    /**
     * 进行扣款操作
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    private void orderCutPay(GoodsOrder goodsOrder){
        //TODO 调取微信接口进行扣款
        long pay = goodsOrder.getPrice();
        //扣款成功后修改支付价格、支付时间、支付状态字段
        goodsOrder.setPay(pay);
        //支付状态
        goodsOrder.setOrderStatus(OrderStatusEnum.PAID.getCode());
        updateGoodsOrder(goodsOrder);
    }
}
