package com.ruoyi.goods.app.service.impl;

import com.ruoyi.goods.app.service.GoodsAppService;
import com.ruoyi.goods.domain.NoticeParam;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.service.impl.SysNoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CLASS_NAME
 * DESCRIPTION 公告阅读实现
 * Date 2021/10/9 15:25
 * ModifyDate 2021/10/9 15:25
 * @Version 1.0
 */
@Service
public class NoticesReadyAppServiceImpl implements GoodsAppService {
    @Autowired
    private SysNoticeServiceImpl sysNoticeServiceImpl;
    @Override
    public <T> T actionRequest(Object obj) {
        NoticeParam noice = (NoticeParam) obj;
        SysNotice sysNotice=new SysNotice();
    /** 公告类型（1通知 2公告 3新闻） */
            //todo 已存在的记录不用插入
        sysNotice.setNoticeId (Long.parseLong (noice.getNoticeId () ));
        sysNotice.setNoticeReadName (noice.getUserId ());
        sysNotice.setNoticeType (noice.getNoticeType ());
        sysNoticeServiceImpl.insertNoticeReady (sysNotice);
        return (T) noice;
    }
}
