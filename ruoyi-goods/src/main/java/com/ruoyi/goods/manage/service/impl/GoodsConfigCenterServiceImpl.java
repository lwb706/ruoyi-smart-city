package com.ruoyi.goods.manage.service.impl;

import com.ruoyi.goods.manage.mapper.GoodsConfigCenterMapper;
import com.ruoyi.goods.base.enums.OperTypeEnum;
import com.ruoyi.goods.base.util.ImgUtil;
import com.ruoyi.goods.domain.ConfigCenter;
import com.ruoyi.goods.manage.service.GoodsManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoodsConfigCenterServiceImpl implements GoodsManageService {
    @Autowired
    private GoodsConfigCenterMapper goodsConfigCenterMapper;
    private final static Logger logger = LoggerFactory
            .getLogger( GoodsConfigCenterServiceImpl.class);
    @Override
    public <T> T actionRequest (Object obj ,String operType) {
        switch (OperTypeEnum.getOperTypeEnum(operType)) {
            case ADD:
                insertConfigCenter(obj);
                break;
            case UPDATE:
                updateConfigCenter(obj);
                break;
            case QUERY:
                return (T) selectConfigCenterList(obj);
            case DELETE:
                deleteConfigCenter(obj);
                break;
            default:
                break;
        }
        return null;
    }
    /**
     * 修改新闻信息
     * @param obj
     */
    private void updateConfigCenter(Object obj){
        //1、修改订单信息
        ConfigCenter configCenter = (ConfigCenter) obj;
        goodsConfigCenterMapper.updateConfigCenter(configCenter);
    }



    /**
     * 修改新闻信息
     * @param obj
     */
    private void insertConfigCenter(Object obj){
        //1、修改订单信息
        ConfigCenter configCenter = (ConfigCenter) obj;
        goodsConfigCenterMapper.insertConfigCenter(configCenter);
    }
    /**
     * 删除新闻信息
     * @param obj
     */
    private void deleteConfigCenter(Object obj){
        //1、修改订单信息
        ConfigCenter ConfigCenter = (ConfigCenter) obj;
        goodsConfigCenterMapper.deleteConfigCenterById(String.valueOf (ConfigCenter.getId ()));
    }
    /**
     * 查询新闻信息列表
     * @param obj
     * @return
     */
    private Map<String, Object> selectConfigCenterList( Object obj){
        Map<String, Object> map = new HashMap<> ();
        ConfigCenter configCenter = (ConfigCenter) obj;
        map.put("pageStart", configCenter.getPageStart());
        map.put("pageLimit", configCenter.getPageLimit());
        configCenter.setPageStart( ImgUtil.getStart(configCenter.getPageStart(), configCenter.getPageLimit()));
        map.put("total",goodsConfigCenterMapper.selectConfigCenterListCount(configCenter));
        map.put("list", goodsConfigCenterMapper.selectConfigCenterList(configCenter));
        return map;
    }

}
