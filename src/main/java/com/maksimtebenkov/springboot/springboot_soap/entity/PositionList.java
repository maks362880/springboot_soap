package com.maksimtebenkov.springboot.springboot_soap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "positin_list")
public class PositionList {
//fk
    @Column(name = "sale_id")
    private int saleId;
//fk
    @Column(name = "goods_id")
    private int goodsId;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "final_price", nullable = false)
    private BigDecimal finalPrice;

    @Column(name = "final_discount_%", nullable = false)
    private int finalDiscountInPercent;

    public PositionList() {
    }

    public PositionList(BigDecimal totalPrice, BigDecimal finalPrice, int finalDiscountInPercent) {
        this.totalPrice = totalPrice;
        this.finalPrice = finalPrice;
        this.finalDiscountInPercent = finalDiscountInPercent;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getFinalDiscountInPercent() {
        return finalDiscountInPercent;
    }

    public void setFinalDiscountInPercent(int finalDiscountInPercent) {
        this.finalDiscountInPercent = finalDiscountInPercent;
    }
}
