package com.ruoyi.goods.manage.service.impl;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.goods.base.enums.OperTypeEnum;
import com.ruoyi.goods.domain.News;
import com.ruoyi.goods.manage.mapper.SysNewsMapper;
import com.ruoyi.goods.manage.service.GoodsManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class NewsManageServiceImpl implements GoodsManageService {
    @Autowired
    private SysNewsMapper newsMapper;
    private final static Logger logger = LoggerFactory
            .getLogger(NewsManageServiceImpl.class);
    @Override
    public <T> T actionRequest (Object obj ,String operType) {
        switch (OperTypeEnum.getOperTypeEnum(operType)) {
            case ADD:
                insertNews(obj);
                break;
            case UPDATE:
                updateNews(obj);
                break;
            case QUERY:
               return (T) selectNewsList(obj);
            case DELETE:
                 deleteNews(obj);
                break;
            default:
                break;
        }
        return null;
    }
    /**
     * 修改新闻信息
     * @param obj
     */
    private void updateNews(Object obj){
        //1、修改订单信息
        News news = (News) obj;
        newsMapper.updateNews(news);
    }



    /**
     * 修改新闻信息
     * @param obj
     */
    private void insertNews(Object obj){
        //1、修改订单信息
        News news = (News) obj;
        if (StringUtils.isNotBlank (news.getDetails ())){
            news.setDetails (handleImg(news.getDetails ()));
        }
        newsMapper.insertNews(news);
    }
   /**
     * 删除新闻信息
     * @param obj
     */
    private void deleteNews(Object obj){
        //1、修改订单信息
        News news = (News) obj;
        newsMapper.deleteNewsById(String.valueOf (news.getNewsId ()));
    }
    /**
     * 查询新闻信息列表
     * @param obj
     * @return
     */
    private List<News> selectNewsList(Object obj){
        News news = (News) obj;
        List<News> newsList = newsMapper.selectNewsList(news);
        return newsList;
    }
    public String handleImg(String imgStr)  {
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

    public String uploads(String imgStr)  {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] result = decoder.decode(imgStr);
        if (imgStr == null)
            return "error";
        //生成jpeg图片D:\ruoyi
        // 上传文件路径
        String filePath = RuoYiConfig.getUploadPath()+"/"+DateUtils.datePath() + "/";
        //String fileName=filePath.concat (DateUtils.datePath() + "/" + IdUtils.fastUUID());
        //String fileName="";
        String fileName=filePath.concat ( IdUtils.fastUUID() ).concat ( ".jpg" );
        //新生成的图片
        OutputStream out=null;
        try {File dir = new File(filePath);
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
            out = new FileOutputStream (fileName);
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
    /**
     * 获取文本中的img标签的src属性值
     * @param htmlStr
     * @return
     */
    public static List<String> getImgSrc(String htmlStr) {
        String img = "";
        Pattern p_image;
        Matcher m_image;
        List<String> pics = new ArrayList<String> ();
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


}
