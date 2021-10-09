package com.ruoyi.goods.domain;

public class Goods {

    /**
     * 唯一Id(雪花算法生成)
     */
    private String id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", pay=" + pay +
                ", sum=" + sum +
                '}';
    }
}
