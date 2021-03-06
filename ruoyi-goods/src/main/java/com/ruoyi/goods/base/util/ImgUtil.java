package com.ruoyi.goods.base.util;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.goods.manage.service.impl.NewsManageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImgUtil {
    private final static Logger logger = LoggerFactory
            .getLogger(ImgUtil.class);

    /**
     * 富文本转换
     * @param imgStr
     * @return
     */
    public static String handleImg(String imgStr)  {
        //String dirPath = url + "newsUpload" + File.separatorChar;
        List<String> imgList=getImgSrc ( imgStr );
        String resultStr=imgStr;
        for (int i = 0; i <imgList.size () ; i++) {
            String str=imgList.get (i);
            String imgPic=str.replace ("data:image/png;base64,","" );
            //System.err.println ("返回结果-----------"+str2);
            //String fineName=String.valueOf (new Date ().getTime ());
            String fileName=uploads(imgPic);//转成图片
            resultStr=resultStr.replace (imgPic, fileName);//将图片替换
            // resultStr=resultStr.replace (imgPic, imagePath.concat ("/").concat (fineName).concat ( ".jpg" ) );//将图片替换
        }
        return resultStr;
    }

    /**
     * 获取文本中的img标签的src属性值
     * @param htmlStr
     * @return
     */
    public static List<String> getImgSrc(String htmlStr) {
        String img = "";
        Pattern p_image;
        Matcher m_image;
        List<String> pics = new ArrayList<String>();
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            img = img + "," + m_image.group();
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }
        return pics;
    }

    /**
     *图片上传
     * @param imgStr
     * @return
     */
    public static String uploads(String imgStr)  {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] result = decoder.decode(imgStr);
        if (imgStr == null)
            return "error";
        //生成jpeg图片D:\ruoyi
        // 上传文件路径
        String filePath = RuoYiConfig.getUploadPath()+"/"+ DateUtils.datePath() + "/";
        //String fileName=filePath.concat (DateUtils.datePath() + "/" + IdUtils.fastUUID());
        //String fileName="";
        String fileName=filePath.concat ( IdUtils.fastUUID() ).concat ( ".jpg" );
        //新生成的图片
        OutputStream out=null;
        try {
            File dir = new File(filePath);
            if (!dir.exists()) {
                logger.info(filePath + ",目录不存在，则建立目录");
                try {
                    dir.mkdirs();
                } catch (Exception e) {
                    logger.info("创建文件目录失败"+e,e);
                }
            }
            //String imgFilePath =filePath+"/"+fileName+".jpg";
            //String fileName=filePath.concat (DateUtils.datePath() + "/" + IdUtils.fastUUID());
            out = new FileOutputStream(fileName);
            out.write(result);
        }catch (Exception e){
            logger.error ( "图片文件存入失败，{}",e.getMessage (),e );
            return "error";
        }finally {
            if (out!=null){
                try{
                    out.flush();
                    out.close();
                }catch (IOException e){
                    logger.error ( "图片文件存入失败，{}",e.getMessage (),e );
                    return "error";
                }
            }
        }
        String finalName= Constants.RESOURCE_PREFIX.concat (fileName.replace ( RuoYiConfig.getProfile (),"" ));
        logger.info ( "图片文件存入地址，{}",finalName);
        return finalName;

    }


    public static int getStart(int pageStart, int pageLimit) {
        int start = 0;
        if (pageStart - 1 <= 0) {
            start = 0;
        } else {
            start = (pageStart - 1) * pageLimit;
        }
        return start;
    }
}
