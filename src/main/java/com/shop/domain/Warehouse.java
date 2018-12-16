package com.shop.domain;

import javax.persistence.*;

@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue
    private int id;
    private  String name;
    private  String street;
    private  String city;
    @Column(name = "postal_code")
    private  String postal;
    @Column(name = "building_number")
    private  String buildingNumber;
    private  String country;

    public Warehouse(String name, String street, String city, String postal, String buildingNumber, String country) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.postal = postal;
        this.buildingNumber = buildingNumber;
        this.country = country;
    }
}
