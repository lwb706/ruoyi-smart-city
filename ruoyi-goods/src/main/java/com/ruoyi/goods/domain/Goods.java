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
    private String carousel;

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
    private String richTextId;

    /**
     * 商品类型
     */
    private String commodityType;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 总数
     */
    private int sum;

    /**
     * 卖出数量
     */
    private int sell;

    /**
     * 商品价格
     */
    private int price;

    /**
     * 折扣价格
     */
    private int discount;

    /**
     * 限定个数
     */
    private int limit;

    /**
     * 商品描述
     */
    private String commodityDesc;

    /**
     * 图文详情
     */
    private String detail;

    /**
     * json
     */
    private String json;

    /**
     * 购买开始时间
     */
    private String tradeStartDate;

    /**
     * 购买结束时间
     */
    private String tradeEndDate;

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

    public String getCarousel() {
        return carousel;
    }

    public void setCarousel(String carousel) {
        this.carousel = carousel;
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

    public String getRichTextId() {
        return richTextId;
    }

    public void setRichTextId(String richTextId) {
        this.richTextId = richTextId;
    }

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
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

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageLimit() {
        return pageLimit;
    }

    public void setPageLimit(int pageLimit) {
        this.pageLimit = pageLimit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", carousel='" + carousel + '\'' +
                ", num=" + num +
                ", showPicture='" + showPicture + '\'' +
                ", richTextId='" + richTextId + '\'' +
                ", commodityType='" + commodityType + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", sum=" + sum +
                ", sell=" + sell +
                ", price=" + price +
                ", discount=" + discount +
                ", limit=" + limit +
                ", commodityDesc='" + commodityDesc + '\'' +
                ", detail='" + detail + '\'' +
                ", json='" + json + '\'' +
                ", tradeStartDate='" + tradeStartDate + '\'' +
                ", tradeEndDate='" + tradeEndDate + '\'' +
                ", pageStart=" + pageStart +
                ", pageLimit=" + pageLimit +
                ", total=" + total +
                '}';
    }
}
