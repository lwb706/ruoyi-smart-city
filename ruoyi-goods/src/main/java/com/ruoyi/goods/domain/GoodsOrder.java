package com.ruoyi.goods.domain;

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
     * 商品规格(json格式)
     */
    private String specifications;

    /**
     * 总计价格：分(无小数位)
     */
    private long price;

    /**
     * 支付价格：分(无小数位)
     */
    private long pay;

    /**
     * 购买总数
     */
    private int sum;

    /**
     * 地址
     */
    private String address;

    /**
     * 手机号码
     */
    private String phone;

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

    @Override
    public String toString() {
        return "GoodsOrder{" +
                "id='" + id + '\'' +
                ", commodityId='" + commodityId + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", specifications='" + specifications + '\'' +
                ", price=" + price +
                ", pay=" + pay +
                ", sum=" + sum +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
