package com.ruoyi.goods.app;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.shiro.service.SysRegisterService;
import com.ruoyi.goods.base.util.Contants;
import com.ruoyi.goods.base.util.GoodsVarOkHttp;
import com.ruoyi.goods.domain.ResultMessage;
import com.ruoyi.system.service.ISysUserOnlineService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.impl.SysRoleServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * CLASS_NAME
 * DESCRIPTION 商品app请求统一Controller
 * Date 2021/10/8 14:44
 * ModifyDate 2021/10/8 14:44
 * @Version 1.0
 */
@RestController
public class LoginAppController extends BaseController{


    private String prefix = "monitor/online";

    @Autowired
    private ISysUserOnlineService userOnlineService;
    @Autowired
    private SysRegisterService sysRegisterService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private GoodsVarOkHttp goodsVarOkHttp;
    @Autowired
    private SysRoleServiceImpl sysRoleServiceImpl;

    @Value("${smsHttps.okhttpUrl}")
    private String httpUrl;
    @RequestMapping("/goods/login")
    public AjaxResult login(String phone)
    {
        ResultMessage resultMessage=new ResultMessage();

        if(StringUtils.isBlank ( phone )){
            resultMessage.setReturnCode ( Contants.PARAM_IS_NULL);
            resultMessage.setReturnMessage ( "请求参数为空" );
            return error (resultMessage);
        }
        UsernamePasswordToken token = new UsernamePasswordToken(phone, "9999999999",false,"AUTO");
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
            SysUser u= userService.selectUserByLoginName(token.getUsername ());
            return success(u);
        }
        catch (AuthenticationException e)
        {
            logger.error ( "登录失败，{}",e.getMessage (),e );
            String msg = "登录失败";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            resultMessage.setReturnCode ( Contants.LOGIN_FAIL );
            resultMessage.setReturnMessage (msg);
            return error(msg);
        }
    }
    //发送短信验证码
    @RequestMapping("/goods/smsCode2222")
    public AjaxResult smsPhoneCode222( String phone)
    {
        logger.info ("获取到的手机号码为,{}",phone  );
        System.out.println("获取到的手机号码为：" + phone);
        SysUser u= userService.selectUserByLoginName(phone);
        String msg="00000";
        if (u==null){
            logger.info ("未查询到该账户数据需要进行注册,{}",phone  );
            //msg="10000";
            success("10000");
        }
        return success(msg);
    }
    //发送短信验证码
    @RequestMapping("/goods/smsCode")
    public AjaxResult smsPhoneCode(HttpServletResponse response, HttpServletRequest request, String phone)
    {
        ResultMessage  res=new ResultMessage();
        JSONObject jsonSession = (JSONObject)request.getSession().getAttribute("verifyCode");
        if(jsonSession != null&&(System.currentTimeMillis() - jsonSession.getLong("createTime")) < 1000 * 60 * 2){
            logger.info("两分钟之内频繁发送验证码：[{}]", jsonSession.getLong("createTime"));
            res.setReturnCode (Contants.PHONE_CHECKCODE_SENDBUSSY);
            res.setReturnMessage ( "请不要重复发送验证码" );
            return error(res);
        }
        //生成6位验证码
        String verifyCode = String.valueOf(new Random ().nextInt(899999) + 100000);
        // # phone=18842897729
           // #code=122344
        logger.info ("获取到的手机号码为,{}",phone);
        JSONObject jsonSend = new JSONObject();
        jsonSend.put("phone", phone);
        jsonSend.put("code", verifyCode);
        String sendMsg = jsonSend.toJSONString();
        HttpSession session = request.getSession();
        JSONObject json = new JSONObject();
        json.put("phone", phone);
        json.put("verifyCode", verifyCode);
        json.put("createTime", System.currentTimeMillis());
        // 将认证码存入SESSION
        request.getSession().setAttribute("verifyCode", json);
        logger.info("发送給手机运营商的验证报文为：[{}]", sendMsg);
        try {
            JSONObject result= goodsVarOkHttp.httpPostJson(httpUrl, sendMsg);
            logger.info("返回结果報文為：[{}]", result.toString ());

        }catch (Exception e){
            logger.error ( "报错结果信息，{}",e.getMessage (),e);
            res.setReturnCode (Contants.RIGISTER_FAIL);
            res.setReturnMessage ( "短信验证码发送失败" );
            return error(res);
        }
        res.setReturnCode (Contants.SUCESS );
        res.setReturnCode ( verifyCode+"短信发送成功");
        return success (res ) ;
        //return success("10000");
    }

    //注册
    @RequestMapping("/goods/registerAppAcc")
    public AjaxResult registerAppAcc(HttpServletResponse response, HttpServletRequest request, String phone,String code)
    {
        ResultMessage  res=new ResultMessage();
        JSONObject json = (JSONObject)request.getSession().getAttribute("verifyCode");
        if(json == null){
            logger.info("内存中没有验证码请核实：[{}]", phone);
            res.setReturnCode (Contants.PHONE_CHECKCODE_FAIL);
            res.setReturnMessage ( "验证码错误" );
            return  error (res );
        }
        if(!json.getString("phone").equals(phone)){
            logger.info("手机号码与内存不一致：[{}]", phone);
            res.setReturnCode (Contants.PHONE_NULBER_FAIL);
            res.setReturnMessage ( "手机号错误" );
            return  error (res);
        }
        if(!json.getString("verifyCode").equals(code)){
            logger.info("内存中没有验证码不一致：[{}]", code);
            res.setReturnCode (Contants.PHONE_CHECKCODE_ERROR);
            res.setReturnMessage ( "验证码错误" );
            return  error ("验证码错误" );
        }
        if((System.currentTimeMillis() - json.getLong("createTime")) > 1000 * 60 * 2){
            logger.info("验证码已过期【{}】",json.getLong("createTime"));
            res.setReturnCode (Contants.PHONE_CHECKCODE_SEND_OUT);
            res.setReturnMessage ( "验证码已过期" );
            error ("验证码已过期" );
        }
        //注册完成后开始插入数据库
        String msg=null;
        try {
            msg= sysRegisterService.registerAppAcc (phone);
        }catch(Exception e){
            logger.error ( "注册失败【{}】",e.getMessage (),e );
            msg="手机APP账号注册失败";
        }
        if ("".equals (msg)){
            res.setReturnCode (Contants.SUCESS );
            res.setReturnCode ("注册成功");
        }else{
            res.setReturnCode (Contants.RIGISTER_FAIL );
            res.setReturnCode (msg);
        }
        return success (res) ;
    }
}
