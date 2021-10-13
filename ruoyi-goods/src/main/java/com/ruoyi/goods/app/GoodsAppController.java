package com.ruoyi.goods.app;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.json.JSON;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.goods.app.enums.GoodsAppActionEnum;
import com.ruoyi.goods.app.router.GoodsAppRouter;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     * @param response
     * @return
     */
    @RequestMapping("/goods/app")
    public Object getParamMessage(HttpServletRequest request, HttpServletResponse response){
        String tranceCode = request.getParameter(TRAN_CODE);
        try {
            if(StringUtils.isNotEmpty(tranceCode)){
                GoodsAppActionEnum goodsAppActionEnum = GoodsAppActionEnum.valueOf(tranceCode);
                Object obj = JSON.unmarshal(request.getParameter(PARAM), goodsAppActionEnum.getDomainClass());
                Object result = goodsAppRouter.getGoodsAppService(tranceCode).actionRequest(obj);
                //返回成功数据
                return success(result);
            }
        } catch (Exception e) {
            logger.warn("商品app,[{}]接口请求失败", tranceCode, e);
            return error(e);
        }
        return error();
    }
}
