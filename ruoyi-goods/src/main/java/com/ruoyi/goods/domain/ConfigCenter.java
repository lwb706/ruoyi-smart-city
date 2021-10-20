package com.ruoyi.goods.domain;
//配置数据表
public class ConfigCenter {
    private int id;
    private String createId;
    private String details;
    private String title;
    private String configType;
    private String createTime;
    private String updateTime;
    private String remarks;
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

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getCreateId () {
        return createId;
    }

    public void setCreateId ( String createId ) {
        this.createId = createId;
    }

    public String getDetails () {
        return details;
    }

    public void setDetails ( String details ) {
        this.details = details;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title;
    }

    public String getConfigType () {
        return configType;
    }

    public void setConfigType ( String configType ) {
        this.configType = configType;
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

    public String getRemarks () {
        return remarks;
    }

    public void setRemarks ( String remarks ) {
        this.remarks = remarks;
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

    @Override
    public String toString () {
        return "ConfigCent{" +
                "id=" + id +
                ", createId='" + createId + '\'' +
                ", details='" + details + '\'' +
                ", title='" + title + '\'' +
                ", configType='" + configType + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", remarks='" + remarks + '\'' +
                ", pageStart=" + pageStart +
                ", pageLimit=" + pageLimit +
                ", total=" + total +
                '}';
    }
}
