package com.ruoyi.goods.domain;
//富文本
public class RichContent {
    private int id;
    private String createId;
    private String content;
    private String title;
    private String createName;
    private String createTime;
    private String updateTime;

    /**
     * 页码
     */
    private int pageStart;

    /**
     * 每页条数
     */
    private int pageLimit;

    /**
     * 总条数
     */
    private int total;



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

    public String getTitle () {
        return title;
    }

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public void setTitle ( String title ) {
        this.title = title;
    }

    public int getPageStart () {
        return pageStart;
    }

    public void setPageStart ( int pageStart ) {
        this.pageStart = pageStart;
    }

    public int getPageLimit () {
        return pageLimit;
    }

    public void setPageLimit ( int pageLimit ) {
        this.pageLimit = pageLimit;
    }

    public int getTotal () {
        return total;
    }

    public void setTotal ( int total ) {
        this.total = total;
    }

    public String getCreateTime () {
        return createTime;
    }

    public void setCreateTime ( String createTime ) {
        this.createTime = createTime;
    }

    public String getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime ( String updateTime ) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString () {
        return "RichContext{" +
                "createId='" + createId + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", createName='" + createName + '\'' +
                '}';
    }
}
