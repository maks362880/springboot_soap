package com.maksimtebenkov.springboot.springboot_soap.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "position_list")
public class PositionList {

    @Id
    @Column(name = "positin_list_id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)//поменять CascadeType.ALL
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne(cascade = CascadeType.ALL)//поменять CascadeType.ALL
    @JoinColumn(name = "goods_id")
    private Goods goods;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
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
