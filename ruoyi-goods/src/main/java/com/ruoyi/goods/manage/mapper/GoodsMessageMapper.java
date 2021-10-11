package com.ruoyi.goods.manage.mapper;

import com.ruoyi.goods.domain.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMessageMapper {
    int insertGoods(Goods goods);
    void updateGoods(Goods goods);
    void deleteGoods(@Param("id") String id);
    List<Goods> queryGoodsList(Goods goods);
}
