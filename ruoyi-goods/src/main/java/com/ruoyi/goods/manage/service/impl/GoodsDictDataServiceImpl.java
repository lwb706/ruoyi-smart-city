package com.ruoyi.goods.manage.service.impl;

import com.ruoyi.goods.base.enums.OperTypeEnum;
import com.ruoyi.goods.base.util.ImgUtil;
import com.ruoyi.goods.domain.ConfigCenter;
import com.ruoyi.goods.manage.mapper.GoodsConfigCenterMapper;
import com.ruoyi.goods.manage.service.GoodsManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoodsDictDataServiceImpl implements GoodsManageService {
    @Autowired
    private GoodsConfigCenterMapper goodsConfigCenterMapper;
    private final static Logger logger = LoggerFactory
            .getLogger( GoodsDictDataServiceImpl.class);
    @Override
    public <T> T actionRequest (Object obj ,String operType) {
        return (T) selectDictData(obj);
    }
    /**
     * 查询数据字典信息列表
     * @param obj
     * @return
     */
    private Map<String, Object> selectDictData( Object obj){
        Map<String, Object> map = new HashMap<> ();
        map.put("list",goodsConfigCenterMapper.selectDictData());
        return map;
    }

}
