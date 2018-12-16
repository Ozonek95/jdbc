package com.shop.domain;

import javax.persistence.*;

@Entity
@Table(name ="products")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private int id;

    private String name;

    @Column(name = "catalog_number")
    private String catalogNumber;
    private String description;
    public Product(String name, String catalogNumber) {
        this.name=name;
        this.catalogNumber=catalogNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Product(){

    }
}
