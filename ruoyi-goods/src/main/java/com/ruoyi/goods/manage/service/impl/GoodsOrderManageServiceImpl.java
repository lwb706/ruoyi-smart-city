package com.ruoyi.goods.manage.service.impl;

import com.ruoyi.goods.app.mapper.GoodsPlaceOrderMapper;
import com.ruoyi.goods.base.enums.OperTypeEnum;
import com.ruoyi.goods.base.enums.OrderStatusEnum;
import com.ruoyi.goods.domain.Goods;
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
        GoodsOrder goodsOrder = (GoodsOrder) obj;
        //退货状态下进行退款操作（管理端操作状态：拒绝退货，同意退货）
        if(OrderStatusEnum.RETURNED.getCode().equals(goodsOrder.getOrderStatus())){
            //2、调取微信接口进行退款操作
            //TODO

            //3、退款成功后把量进行还原操作
            addGoodsNum(goodsOrder);
        }
        //退款成功后，修改订单信息
        goodsPlaceOrderMapper.updateGoodsOrder(goodsOrder);
    }

    /**
     * 修改商量卖出数量
     * @param goodsOrder
     * @throws Exception
     */
    private void addGoodsNum(GoodsOrder goodsOrder){
        Goods goods = new Goods();
        goods.setId(goodsOrder.getCommodityId());
        List<Goods> goodsList = goodsMessageMapper.queryGoodsList(goods);
        if(goodsList.size() > 0){
            int sell = goodsList.get(0).getSell() - goodsOrder.getSum();
            if(sell < 0){
                sell = 0;
            }
            goods.setSell(sell);
            goodsMessageMapper.updateGoods(goods);
        }

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
