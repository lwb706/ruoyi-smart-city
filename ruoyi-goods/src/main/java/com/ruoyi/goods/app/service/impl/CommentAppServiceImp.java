package com.ruoyi.goods.app.service.impl;

import com.ruoyi.goods.app.service.GoodsAppService;
import com.ruoyi.goods.domain.CommentNews;
import com.ruoyi.goods.manage.mapper.SysNewsContextMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentAppServiceImp implements GoodsAppService {
    @Autowired
    private SysNewsContextMapper sysNewsContextMapper;
    private final static Logger logger = LoggerFactory
            .getLogger( CommentAppServiceImp.class);
    @Override
    public <T> T actionRequest(Object obj) {
        CommentNews commentNews = (CommentNews) obj;
        try{
            insertComment(commentNews);
        }catch (Exception e){
            logger.error ( "评论失败，{}",e.getMessage (),e );
        }
        return (T) commentNews;
    }
    /**
     * 修改评论信息
     * @param commentNews
     */
    private void insertComment(CommentNews commentNews){
        //1、修改订单信息
        sysNewsContextMapper.insertComment(commentNews);
    }
}
