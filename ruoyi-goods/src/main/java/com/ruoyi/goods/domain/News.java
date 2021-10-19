package com.ruoyi.goods.domain;

//错误码及错误信息包装类
public class News {
   private  long    newsId;
   private  String  title;
   private  String  type;
   private  String  carouselName;
   private  String  thumbnailName;
   private  String  details;
   private  String  createTime;
   private  String  readyNumber;
   private  String  collectionNumber;
   private  String  createBy;
   private  String relationId;

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

    public long getNewsId () {
        return newsId;
    }

    public void setNewsId ( long newsId ) {
        this.newsId = newsId;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle ( String title ) {
        this.title = title;
    }

    public String getType () {
        return type;
    }

    public void setType ( String type ) {
        this.type = type;
    }

    public String getCarouselName () {
        return carouselName;
    }

    public void setCarouselName ( String carouselName ) {
        this.carouselName = carouselName;
    }

    public String getThumbnailName () {
        return thumbnailName;
    }

    public void setThumbnailName ( String thumbnailName ) {
        this.thumbnailName = thumbnailName;
    }

    public String getDetails () {
        return details;
    }

    public void setDetails ( String details ) {
        this.details = details;
    }

    public String getCreateTime () {
        return createTime;
    }

    public void setCreateTime ( String createTime ) {
        this.createTime = createTime;
    }

    public String getReadyNumber () {
        return readyNumber;
    }

    public void setReadyNumber ( String readyNumber ) {
        this.readyNumber = readyNumber;
    }

    public String getCollectionNumber () {
        return collectionNumber;
    }

    public void setCollectionNumber ( String collectionNumber ) {
        this.collectionNumber = collectionNumber;
    }

    public String getCreateBy () {
        return createBy;
    }

    public void setCreateBy ( String createBy ) {
        this.createBy = createBy;
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

    public String getRelationId () {
        return relationId;
    }

    public void setRelationId ( String relationId ) {
        this.relationId = relationId;
    }

    @Override
    public String toString () {
        return "News{" +
                "newsId=" + newsId +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", carouselName='" + carouselName + '\'' +
                ", thumbnailName='" + thumbnailName + '\'' +
                ", details='" + details + '\'' +
                ", createTime='" + createTime + '\'' +
                ", readyNumber='" + readyNumber + '\'' +
                ", collectionNumber='" + collectionNumber + '\'' +
                ", createBy='" + createBy + '\'' +
                '}';
    }
}
