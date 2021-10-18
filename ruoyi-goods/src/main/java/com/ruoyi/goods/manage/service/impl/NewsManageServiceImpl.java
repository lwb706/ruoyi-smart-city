package com.ruoyi.goods.manage.service.impl;

import com.ruoyi.goods.base.enums.OperTypeEnum;
import com.ruoyi.goods.domain.News;
import com.ruoyi.goods.manage.mapper.SysNewsContextMapper;
import com.ruoyi.goods.manage.service.GoodsManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsManageServiceImpl implements GoodsManageService {
    @Autowired
    private SysNewsContextMapper sysNewsContextMapper;
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
        sysNewsContextMapper.updateNews(news);
    }



    /**
     * 修改新闻信息
     * @param obj
     */
    private void insertNews(Object obj){
        //1、修改订单信息
        News news = (News) obj;
        /*if (StringUtils.isNotBlank (news.getDetails ())){
            news.setDetails (ImgUtil.handleImg(news.getDetails ()));
        }*/
        sysNewsContextMapper.insertNews(news);
    }
   /**
     * 删除新闻信息
     * @param obj
     */
    private void deleteNews(Object obj){
        //1、修改订单信息
        News news = (News) obj;
        sysNewsContextMapper.deleteNewsById(String.valueOf (news.getNewsId ()));
    }
    /**
     * 查询新闻信息列表
     * @param obj
     * @return
     */
    private List<News> selectNewsList(Object obj){
        News news = (News) obj;
        List<News> newsList = sysNewsContextMapper.selectNewsList(news);
        return newsList;
    }




}
