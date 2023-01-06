package com.maksimtebenkov.springboot.springboot_soap.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "product_discount_%")
    private int productDiscountPercent;

    @Column(name = "description")
    private String description;

    @Column(name = "customer_ratings")
    private BigDecimal customerRatings;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
//    private Map<Integer, Integer> customerRatings;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goods")
    private List<PositionList> positionLists;

    public Goods() {
    }

    public Goods(String productName, BigDecimal price, String description, BigDecimal customerRatings) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.customerRatings = customerRatings;
    }

    public void addPositionListToGoods(PositionList positionList) {
        if (positionLists == null) {
            positionLists = new ArrayList<>();
        }
        positionLists.add(positionList);
        positionList.setGoods(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCustomerRatings() {
        return customerRatings;
    }

    public void setCustomerRatings(BigDecimal customerRatings) {
        this.customerRatings = customerRatings;
    }

    public int getProductDiscountPercent() {
        return productDiscountPercent;
    }

    public void setProductDiscountPercent(int productDiscountPercent) {
        this.productDiscountPercent = productDiscountPercent;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", customerRatings=" + customerRatings +
                '}';
    }
}
