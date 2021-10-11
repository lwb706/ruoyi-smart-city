package com.ruoyi.goods.manage.service.impl;

import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.goods.base.enums.OperTypeEnum;
import com.ruoyi.goods.domain.Goods;
import com.ruoyi.goods.manage.mapper.GoodsMessageMapper;
import com.ruoyi.goods.manage.service.GoodsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        goodsMessageMapper.updateGoods(goods);
    }

    /**
     * 删除商品信息
     * @param obj
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    private void deleteGoods(Object obj){
        String id = (String) obj;
        goodsMessageMapper.deleteGoods(id);
    }

    /**
     * 查询商品信息列表
     * @param obj
     * @return
     */
    private List<Goods> queryGoodsList(Object obj){
        Goods goods = (Goods) obj;
        return goodsMessageMapper.queryGoodsList(goods);
    }
}
