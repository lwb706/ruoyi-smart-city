package com.ruoyi.goods.app.mapper;

import com.ruoyi.goods.domain.GoodsOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsPlaceOrderMapper {
    int insertGoodsOrder(GoodsOrder goodsOrder);
    void updateGoodsOrder(GoodsOrder goodsOrder);
    void deleteGoodsOrder(@Param("id") String id);
    List<GoodsOrder> queryGoodsOrderList(GoodsOrder goodsOrder);
    int queryGoodsOrderCount(GoodsOrder goodsOrder);
}
