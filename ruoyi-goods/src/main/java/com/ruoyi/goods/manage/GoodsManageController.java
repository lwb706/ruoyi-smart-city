package com.ruoyi.goods.manage;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.goods.base.util.Contants;
import com.ruoyi.goods.base.util.JacksonUtil;
import com.ruoyi.goods.domain.ResultMessage;
import com.ruoyi.goods.manage.enums.GoodsManageActionEnum;
import com.ruoyi.goods.manage.router.GoodsManageRouter;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CLASS_NAME
 * DESCRIPTION 商品管理端请求统一Controller
 * Date 2021/10/8 14:44
 * ModifyDate 2021/10/8 14:44
 * @Version 1.0
 */
@RestController
public class GoodsManageController extends BaseController{


    private static final String TRAN_CODE = "tranCode";

    private static final String PARAM = "param";

    @Autowired
    private GoodsManageRouter goodsManageRouter;


    /**
     * manage Action请求接口
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/goods/manage")
    public Object getParamMessage(HttpServletRequest request, HttpServletResponse response){
        String tranceCode = request.getParameter(TRAN_CODE);
        try {
            if(StringUtils.isNotEmpty(tranceCode)){
                GoodsManageActionEnum goodsManageActionEnum = GoodsManageActionEnum.valueOf(tranceCode);
                Object obj = JacksonUtil.json2pojo(request.getParameter(PARAM), goodsManageActionEnum.getDomainClass());
                Object result = goodsManageRouter.getGoodsManageService(tranceCode).actionRequest(obj, goodsManageActionEnum.getOperType());
                //返回成功数据
                return success(result);
            }
        } catch (Exception e) {
            logger.warn("商品管理端,[{}]接口请求失败", tranceCode, e);
        }
        return error();
    }
    //文件上传
    @PostMapping("/goods/addSave")
    public AjaxResult addSave( @RequestParam("file") MultipartFile file, FileInfo fileInfo) throws IOException
    {
        ResultMessage res=new ResultMessage ();

        // 上传文件路径
        String filePath = RuoYiConfig.getUploadPath();
        // 上传并返回新文件名称
        try{
            String fileName = FileUploadUtils.upload(filePath, file);
            res.setReturnCode (Contants.SUCESS);
            res.setReturnMessage (fileName);
        }catch (Exception e){
            logger.error ( "文件上传失败【{}】", e.getMessage (),e);
            res.setReturnCode (Contants.FAIL_UPLOAD_FILE);
            res.setReturnMessage ("文件上传失败");
        }

        //fileInfo.setFilePath(fileName);
        return success (res);
    }
}
