package com.ruoyi.goods.app;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.goods.app.enums.GoodsAppActionEnum;
import com.ruoyi.goods.app.router.GoodsAppRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * CLASS_NAME
 * DESCRIPTION 商品app请求统一Controller
 * Date 2021/10/8 14:44
 * ModifyDate 2021/10/8 14:44
 * @Version 1.0
 */
@RestController
public class GoodsAppController extends BaseController{




    private static final String TRAN_CODE = "tranCode";

    private static final String PARAM = "param";

    @Autowired
    private GoodsAppRouter goodsAppRouter;


    /**
     * app Action请求接口
     * @param request
     * @param param
     * @return
     */
    @RequestMapping("/goods/app")
    public Object getParamMessage(HttpServletRequest request, @RequestBody Map<Object,Object> param){
        String tranCode= (String) param.get("tranCode");
        SysUser user = (SysUser)request.getSession().getAttribute("SysUser");
//        if (user==null){
//            ResultMessage res=new ResultMessage();
//            res.setReturnCode ( Contants.LOGIN_NONE);
//            res.setReturnMessage ( "用户未登录" );
//            return success(res);
//        }
        try {
            if(StringUtils.isNotEmpty(tranCode)){
                GoodsAppActionEnum goodsAppActionEnum = GoodsAppActionEnum.valueOf(tranCode);
                String jsonString = JSON.toJSONString(param);
                Object obj = JSON.parseObject(jsonString, goodsAppActionEnum.getDomainClass());//json转对象
                Object result = goodsAppRouter.getGoodsAppService(tranCode).actionRequest(obj);
                //返回成功数据
                return success(result);
            }
        } catch (Exception e) {
            logger.warn("商品app,[{}]接口请求失败", tranCode, e);
            return error(e.getMessage());
        }
        return error();
    }



}
