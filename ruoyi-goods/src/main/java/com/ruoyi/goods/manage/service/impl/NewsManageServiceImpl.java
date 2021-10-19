package com.ruoyi.goods.manage.service.impl;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.goods.base.enums.OperTypeEnum;
import com.ruoyi.goods.base.util.ImgUtil;
import com.ruoyi.goods.domain.News;
import com.ruoyi.goods.manage.mapper.GoodsNewsContextMapper;
import com.ruoyi.goods.manage.service.GoodsManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NewsManageServiceImpl implements GoodsManageService {
    @Autowired
    private GoodsNewsContextMapper goodsNewsContextMapper;
    private final static Logger logger = LoggerFactory
            .getLogger(NewsManageServiceImpl.class);
    @Override
    public <T> T actionRequest (Object obj ,String operType) {
        switch (OperTypeEnum.getOperTypeEnum(operType)) {
            case ADD:
                insertNews(obj);
                break;
            case UPDATE:
                updateNews(obj);
                break;
            case QUERY:
               return (T) selectNewsList(obj);
            case DELETE:
                 deleteNews(obj);
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
    private void updateNews(Object obj){
        //1、修改订单信息
        News news = (News) obj;
        /*if (StringUtils.isNotBlank (news.getDetails ())){
            news.setDetails (ImgUtil.handleImg(news.getDetails ()));
        }*/
        goodsNewsContextMapper.updateNews(news);
    }



    /**
     * 修改新闻信息
     * @param obj
     */
    private void insertNews(Object obj){
        //1、修改订单信息
        News news = (News) obj;
        if (StringUtils.isNotBlank (news.getDetails ())){
            news.setDetails (ImgUtil.handleImg(news.getDetails ()));
        }
        goodsNewsContextMapper.insertNews(news);
    }
   /**
     * 删除新闻信息
     * @param obj
     */
    private void deleteNews(Object obj){
        //1、修改订单信息
        News news = (News) obj;
        goodsNewsContextMapper.deleteNewsById(String.valueOf (news.getNewsId ()));
    }
    /**
     * 查询新闻信息列表
     * @param obj
     * @return
     */
    private Map<String, Object> selectNewsList(Object obj){
        Map<String, Object> map = new HashMap<> ();
        News news = (News) obj;
        map.put("pageStart", news.getPageStart());
        map.put("pageLimit", news.getPageLimit());
        news.setPageStart( ImgUtil.getStart(news.getPageStart(), news.getPageLimit()));
        map.put("total",goodsNewsContextMapper.selectNewsListCount(news));
        map.put("list", goodsNewsContextMapper.selectNewsList(news));
       // List<News> newsList = sysNewsContextMapper.selectNewsList(news);
        return map;
    }




}
