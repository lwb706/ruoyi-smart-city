package com.ruoyi.goods.domain;
//富文本
public class RichText {
   public String createId;
   public String content;
   public  String createName;

    public String getCreateId () {
        return createId;
    }

    public void setCreateId ( String createId ) {
        this.createId = createId;
    }

    public String getContent () {
        return content;
    }

    public void setContent ( String content ) {
        this.content = content;
    }

    public String getCreateName () {
        return createName;
    }

    public void setCreateName ( String createName ) {
        this.createName = createName;
    }

    @Override
    public String toString () {
        return "RichText{" +
                "createId='" + createId + '\'' +
                ", content='" + content + '\'' +
                ", createName='" + createName + '\'' +
                '}';
    }
}
