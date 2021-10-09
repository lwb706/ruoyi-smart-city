package com.ruoyi.goods.domain;

/**
 * CLASS_NAME
 * DESCRIPTION 商品信息
 * Date 2021/10/9 15:24
 * ModifyDate 2021/10/9 15:24
 * @Version 1.0
 */
public class Goods extends BaseDomain{

    /**
     * 唯一Id(UUID生成)
     */
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 类型  1：主页置顶商品  2：信息商品列表
     */
    private int type;

    /**
     * 轮播图
     */
    private String rotationPicture;

    /**
     * 排列序号
     */
    private int num;

    /**
     * 缩略图展示
     */
    private String showPicture;

    /**
     * 富文本
     */
    private String richText;

    /**
     * 商品类型
     */
    private String commodityType;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 库存
     */
    private int stock;

    /**
     * 商品价格
     */
    private int price;

    /**
     * 折扣价格
     */
    private int disPrice;

    /**
     * 限定个数
     */
    private int limit;

    /**
     * 商品描述
     */
    private String commodityDesc;

    /**
     * 购买开始时间
     */
    private String tradeStartDate;

    /**
     * 购买结束时间
     */
    private String tradeEndDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getRotationPicture() {
        return rotationPicture;
    }

    public void setRotationPicture(String rotationPicture) {
        this.rotationPicture = rotationPicture;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getShowPicture() {
        return showPicture;
    }

    public void setShowPicture(String showPicture) {
        this.showPicture = showPicture;
    }

    public String getRichText() {
        return richText;
    }

    public void setRichText(String richText) {
        this.richText = richText;
    }

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDisPrice() {
        return disPrice;
    }

    public void setDisPrice(int disPrice) {
        this.disPrice = disPrice;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getCommodityDesc() {
        return commodityDesc;
    }

    public void setCommodityDesc(String commodityDesc) {
        this.commodityDesc = commodityDesc;
    }

    public String getTradeStartDate() {
        return tradeStartDate;
    }

    public void setTradeStartDate(String tradeStartDate) {
        this.tradeStartDate = tradeStartDate;
    }

    public String getTradeEndDate() {
        return tradeEndDate;
    }

    public void setTradeEndDate(String tradeEndDate) {
        this.tradeEndDate = tradeEndDate;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", rotationPicture='" + rotationPicture + '\'' +
                ", num=" + num +
                ", showPicture='" + showPicture + '\'' +
                ", richText='" + richText + '\'' +
                ", commodityType='" + commodityType + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", disPrice=" + disPrice +
                ", limit=" + limit +
                ", commodityDesc='" + commodityDesc + '\'' +
                ", tradeStartDate='" + tradeStartDate + '\'' +
                ", tradeEndDate='" + tradeEndDate + '\'' +
                '}';
    }
}
