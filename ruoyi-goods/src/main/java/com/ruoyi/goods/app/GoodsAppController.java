package com.ruoyi.goods.app;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.json.JSON;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.goods.app.enums.GoodsAppActionEnum;
import com.ruoyi.goods.app.router.GoodsAppRouter;
import com.ruoyi.goods.app.service.GoodsAppService;
import com.ruoyi.goods.app.service.impl.GoodsAppServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
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


    private static final String TRANCE_CODE = "tranceCode";

    private static final String PARAM = "param";

    @Autowired
    private GoodsAppRouter goodsAppRouter;

    @PostConstruct
    public void init(){
        System.out.println("判断模块有没有被加载！");
    }

    @RequestMapping("/app")
    public Object getParamMessage(HttpServletRequest request, HttpServletResponse response){
        String tranceCode = request.getParameter(TRANCE_CODE);
        try {
            if(StringUtils.isNotEmpty(tranceCode)){
                GoodsAppActionEnum goodsAppActionEnum = GoodsAppActionEnum.valueOf(tranceCode);
                String result = goodsAppRouter.getGoodsAppService(tranceCode).actionRequest();
                System.out.println(result);
                return result;
                //TODO 各自实现里面把json参数转换为对象
                //Object obj = JSON.unmarshal(request.getParameter(PARAM), goodsAppActionEnum.getDomainClass());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
}
