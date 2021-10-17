package com.ruoyi.goods.domain;

public class CommentNews {
    String userId;
    String content;
    String newsId;

    public String getUserId () {
        return userId;
    }

    public void setUserId ( String userId ) {
        this.userId = userId;
    }

    public String getNewsId () {
        return newsId;
    }

    public void setNewsId ( String newsId ) {
        this.newsId = newsId;
    }

    public String getContent () {
        return content;
    }

    public void setContent ( String content ) {
        this.content = content;
    }

    @Override
    public String toString () {
        return "CommentNews{" +
                "userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", newsId='" + newsId + '\'' +
                '}';
    }
}
