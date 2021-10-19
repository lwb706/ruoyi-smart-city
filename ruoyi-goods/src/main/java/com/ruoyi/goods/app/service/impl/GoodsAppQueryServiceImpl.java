package com.ruoyi.goods.app.service.impl;

import com.ruoyi.goods.app.service.GoodsAppService;
import com.ruoyi.goods.base.util.ImgUtil;
import com.ruoyi.goods.domain.Goods;
import com.ruoyi.goods.manage.mapper.GoodsMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * CLASS_NAME
 * DESCRIPTION 商品查询接口实现
 * Date 2021/10/9 15:25
 * ModifyDate 2021/10/9 15:25
 * @Version 1.0
 */
@Service
public class GoodsAppQueryServiceImpl implements GoodsAppService {
    @Autowired
    private GoodsMessageMapper goodsMessageMapper;

    @Override
    public <T> T actionRequest(Object obj) {
        Goods goods = (Goods) obj;
        return (T) queryGoodsList(goods);
    }

    /**
     * 查询商品信息列表
     * @param obj
     * @return
     */
    private Map<String, Object> queryGoodsList(Object obj){
        Map<String, Object> map = new HashMap<>();
        Goods goods = (Goods) obj;
        map.put("pageStart", goods.getPageStart());
        map.put("pageLimit", goods.getPageLimit());
        goods.setPageStart(ImgUtil.getStart(goods.getPageStart(), goods.getPageLimit()));
        map.put("total", goodsMessageMapper.queryGoodsCount(goods));
        map.put("list", goodsMessageMapper.queryGoodsList(goods));
        return map;
    }
}
