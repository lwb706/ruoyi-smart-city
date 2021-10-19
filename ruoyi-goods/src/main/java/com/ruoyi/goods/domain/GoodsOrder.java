package com.ruoyi.goods.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * CLASS_NAME
 * DESCRIPTION 商品订单信息
 * Date 2021/10/9 15:23
 * ModifyDate 2021/10/9 15:23
 * @Version 1.0
 */
public class GoodsOrder {

    /**
     * 唯一Id(UUID生成)
     */
    private String id;

    /**
     * 商品ID
     */
    private String commodityId;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 类型；普通商品，门票
     */
    private String type;

    /**
     * 商品规格(json格式)
     */
    private String specifications;

    /**
     * 总计价格：分(无小数位)
     */
    private long price;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 支付价格：分(无小数位)
     */
    private long pay;

    /**
     * 购买总数
     */
    private int sum;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 地址
     */
    private String address;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 支付时间
     */
    private String payTime;

    private String json;

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

    /**
     * 查询开始日期
     */
    private String startDate;

    /**
     * 查询结束日期
     */
    private String endDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPay() {
        return pay;
    }

    public void setPay(long pay) {
        this.pay = pay;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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
        return "GoodsOrder{" +
                "id='" + id + '\'' +
                ", commodityId='" + commodityId + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", type='" + type + '\'' +
                ", specifications='" + specifications + '\'' +
                ", price=" + price +
                ", orderStatus='" + orderStatus + '\'' +
                ", pay=" + pay +
                ", sum=" + sum +
                ", userId='" + userId + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", payTime=" + payTime +
                ", json='" + json + '\'' +
                ", pageStart=" + pageStart +
                ", pageLimit=" + pageLimit +
                ", total=" + total +
                '}';
    }
}
