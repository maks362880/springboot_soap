package com.maksimtebenkov.springboot.springboot_soap.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_name")
    private String customer_name;


    @Column(name = " individual_discount_1")
    private int individualDiscount1;

    @Column(name = " individual_discount_2")
    private int individualDiscount2;

    public Customer() {
    }

    public Customer(String customer_name, int individualDiscount1, int individualDiscount2) {
        this.customer_name = customer_name;
        this.individualDiscount1 = individualDiscount1;
        this.individualDiscount2 = individualDiscount2;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getIndividualDiscount1() {
        return individualDiscount1;
    }

    public void setIndividualDiscount1(int individualDiscount1) {
        this.individualDiscount1 = individualDiscount1;
    }

    public int getIndividualDiscount2() {
        return individualDiscount2;
    }

    public void setIndividualDiscount2(int individualDiscount2) {
        this.individualDiscount2 = individualDiscount2;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customer_name='" + customer_name + '\'' +
                ", individualDiscount1=" + individualDiscount1 +
                ", individualDiscount2=" + individualDiscount2 +
                '}';
    }
}
