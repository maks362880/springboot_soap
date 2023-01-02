package com.maksimtebenkov.springboot.springboot_soap.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "goods")
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id",nullable = false)
    private int id;

    @Column(name = "product_name")
    private String ProductName;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    @Column(name = "customer_ratings")
    private BigDecimal customerRatings;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goods")
    private List<PositionList> positionList;

    public Goods() {
    }

    public Goods(String productName, BigDecimal price, String description, BigDecimal customerRatings) {
        ProductName = productName;
        this.price = price;
        this.description = description;
        this.customerRatings = customerRatings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
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

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", ProductName='" + ProductName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", customerRatings=" + customerRatings +
                '}';
    }
}
