package com.maksimtebenkov.springboot.springboot_soap.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "position_list")
public class PositionList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @ManyToOne(cascade = CascadeType.ALL)//поменять CascadeType
    @JoinColumn(name = "sale_id")//, insertable = false, updatable = false
    private Sale sale;

    @ManyToOne(cascade = CascadeType.ALL)//поменять CascadeType
    @JoinColumn(name = "goods_id")//, insertable = false, updatable = false)
    private Goods goods;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "final_price", nullable = false)
    private BigDecimal finalPrice;

    @Column(name = "final_discount", nullable = false)
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

    @Override
    public String toString() {
        return "PositionList{" +
                "id=" + id +
                ", sale=" + sale +
                ", goods=" + goods +
                ", totalPrice=" + totalPrice +
                ", finalPrice=" + finalPrice +
                ", finalDiscountInPercent=" + finalDiscountInPercent +
                '}';
    }
}
