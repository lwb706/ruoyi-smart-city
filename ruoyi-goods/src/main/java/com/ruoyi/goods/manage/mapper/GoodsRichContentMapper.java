package com.ruoyi.goods.manage.mapper;
import com.ruoyi.goods.domain.CommentNews;
import com.ruoyi.goods.domain.News;
import com.ruoyi.goods.domain.RichContent;

import java.util.List;

public interface GoodsRichContentMapper {
    int  insertRichContent ( RichContent news );
    void updateRichContent ( RichContent news );
    void deleteRichContentById ( String newsId );
    List<RichContent> selectRichContentList ( RichContent news );
    int selectRichContentListCount ( RichContent news );
}
