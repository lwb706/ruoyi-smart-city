package com.ruoyi.goods.manage.mapper;
import com.ruoyi.goods.domain.ConfigCenter;

import java.util.List;
public interface GoodsConfigCenterMapper {
    int  insertConfigCenter ( ConfigCenter configCenter );
    void updateConfigCenter ( ConfigCenter configCenter );
    void deleteConfigCenterById ( String Id );
    List<ConfigCenter> selectConfigCenterList ( ConfigCenter configCenter );
    int selectConfigCenterListCount ( ConfigCenter configCenter );
}
