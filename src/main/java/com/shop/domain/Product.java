package com.shop.domain;

import javax.persistence.*;

@Entity
@Table(name ="products")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="price_id")
    private Price price;

    private String name;

    @Column(name = "catalog_number")
    private String catalogNumber;
    private String description;


    public Product(Price price, String name, String catalogNumber) {
        this.price = price;
        this.name=name;
        this.catalogNumber=catalogNumber;
    }


    private Product(){

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", catalogNumber='" + catalogNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void changeDescription(String description) {
        this.description = description;
    }
}
