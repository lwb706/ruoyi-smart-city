package com.ruoyi.goods.manage.service.impl;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.goods.base.enums.OperTypeEnum;
import com.ruoyi.goods.base.util.ImgUtil;
import com.ruoyi.goods.domain.Goods;
import com.ruoyi.goods.manage.mapper.GoodsMessageMapper;
import com.ruoyi.goods.manage.service.GoodsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CLASS_NAME
 * DESCRIPTION 商品新增接口实现
 * Date 2021/10/9 15:25
 * ModifyDate 2021/10/9 15:25
 * @Version 1.0
 */
@Service
public class GoodsManageServiceImpl implements GoodsManageService {

    @Autowired
    private GoodsMessageMapper goodsMessageMapper;

    @Override
    public <T> T actionRequest(Object obj,String operType) {
        switch (OperTypeEnum.getOperTypeEnum(operType)) {
            case ADD:
                addGoods(obj);
                break;
            case UPDATE:
                updateGoods(obj);
                break;
            case DELETE:
                deleteGoods(obj);
                break;
            case QUERY:
                return (T) queryGoodsList(obj);
            default:
                break;
        }
        return null;
    }

    /**
     * 管理端新增商品信息
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    private void addGoods(Object obj){
        Goods goods = (Goods) obj;
        if(StringUtils.isNotEmpty(goods.getRichTextId())){
            //富文本转换
            goods.setRichTextId(ImgUtil.handleImg(goods.getRichTextId()));
        }
        //生成唯一ID
        goods.setId(IdUtils.fastSimpleUUID());
        goodsMessageMapper.insertGoods(goods);
    }

    /**
     * 管理端修改商品信息
     * @param obj
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    private void updateGoods(Object obj){
        Goods goods = (Goods) obj;
        if(StringUtils.isNotEmpty(goods.getRichTextId())){
            //富文本转换
            goods.setRichTextId(ImgUtil.handleImg(goods.getRichTextId()));
        }
        goodsMessageMapper.updateGoods(goods);
    }

    /**
     * 删除商品信息
     * @param obj
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    private void deleteGoods(Object obj){
        Goods goods = (Goods) obj;
        goodsMessageMapper.deleteGoods(goods.getId());
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
