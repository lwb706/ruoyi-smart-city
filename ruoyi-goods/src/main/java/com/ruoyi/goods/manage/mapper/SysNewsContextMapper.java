package com.ruoyi.goods.manage.mapper;
import com.ruoyi.goods.domain.CommentNews;
import com.ruoyi.goods.domain.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface SysNewsContextMapper {
    int  insertNews ( News news );
    void updateNews ( News news );
    void deleteNewsById ( String newsId );
    List<News> selectNewsList ( News news );
    int  insertComment ( CommentNews commentNews );

}
