package com.ruoyi.goods.domain;

public class NoticeParam {
    String userId;//用户id
    int tradeType;//0:查询公告全部信息，1：查看单条公告信息
    String noticeId;//公告ID
    String noticeType;//公告类型


    public String getUserId () {
        return userId;
    }

    public void setUserId ( String userId ) {
        this.userId = userId;
    }

    public int getTradeType () {
        return tradeType;
    }

    public void setTradeType ( int tradeType ) {
        this.tradeType = tradeType;
    }

    public String getNoticeId () {
        return noticeId;
    }

    public void setNoticeId ( String noticeId ) {
        this.noticeId = noticeId;
    }

    public String getNoticeType () {
        return noticeType;
    }

    public void setNoticeType ( String noticeType ) {
        this.noticeType = noticeType;
    }

    @Override
    public String toString () {
        return "NoiceParam{" +
                "userId='" + userId + '\'' +
                ", tradeType=" + tradeType +
                ", noiceId='" + noticeId + '\'' +
                ", noiceType='" + noticeType + '\'' +
                '}';
    }
}
