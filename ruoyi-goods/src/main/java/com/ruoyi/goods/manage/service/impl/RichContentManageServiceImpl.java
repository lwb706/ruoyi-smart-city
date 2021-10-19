package com.ruoyi.goods.manage.service.impl;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.goods.base.enums.OperTypeEnum;
import com.ruoyi.goods.base.util.ImgUtil;
import com.ruoyi.goods.domain.News;
import com.ruoyi.goods.domain.RichContent;
import com.ruoyi.goods.manage.mapper.GoodsNewsContextMapper;
import com.ruoyi.goods.manage.mapper.GoodsRichContentMapper;
import com.ruoyi.goods.manage.service.GoodsManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class RichContentManageServiceImpl implements GoodsManageService {
    @Autowired
    private GoodsRichContentMapper goodsRichContentMapper;
    private final static Logger logger = LoggerFactory
            .getLogger(RichContentManageServiceImpl.class);
    @Override
    public <T> T actionRequest (Object obj ,String operType) {
        switch (OperTypeEnum.getOperTypeEnum(operType)) {
            case ADD:
                insertRichContent(obj);
                break;
            case UPDATE:
                updateRichContent(obj);
                break;
            case QUERY:
                return (T) selectRichContentList(obj);
            case DELETE:
                deleteRichContent(obj);
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
    private void updateRichContent(Object obj){
        //1、修改订单信息
        RichContent richContent = (RichContent) obj;
        if (StringUtils.isNotBlank (richContent.getContent ())){
            richContent.setContent (ImgUtil.handleImg(richContent.getContent ()));
        }
        goodsRichContentMapper.updateRichContent(richContent);
    }



    /**
     * 修改新闻信息
     * @param obj
     */
    private void insertRichContent(Object obj){
        //1、修改订单信息
        RichContent richContent = (RichContent) obj;
        if (StringUtils.isNotBlank (richContent.getContent ())){
            richContent.setContent (ImgUtil.handleImg(richContent.getContent ()));
        }
        goodsRichContentMapper.insertRichContent(richContent);
    }
    /**
     * 删除新闻信息
     * @param obj
     */
    private void deleteRichContent(Object obj){
        //1、修改订单信息
        RichContent richContent = (RichContent) obj;
        goodsRichContentMapper.deleteRichContentById(String.valueOf (richContent.getId ()));
    }
    /**
     * 查询新闻信息列表
     * @param obj
     * @return
     */
    private Map<String, Object> selectRichContentList( Object obj){
        Map<String, Object> map = new HashMap<> ();
        RichContent richContent = (RichContent) obj;
        map.put("pageStart", richContent.getPageStart());
        map.put("pageLimit", richContent.getPageLimit());
        richContent.setPageStart( ImgUtil.getStart(richContent.getPageStart(), richContent.getPageLimit()));
        map.put("total",goodsRichContentMapper.selectRichContentListCount(richContent));
        map.put("list", goodsRichContentMapper.selectRichContentList(richContent));
        List<RichContent> richContentList = goodsRichContentMapper.selectRichContentList(richContent);
        return map;
    }

}
