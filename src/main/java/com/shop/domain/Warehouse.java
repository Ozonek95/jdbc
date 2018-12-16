package com.shop.domain;

import org.hibernate.annotations.Cascade;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Warehouse(String name, String street, String city, String postal, String buildingNumber, String country, Owner owner) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.postal = postal;
        this.buildingNumber = buildingNumber;
        this.country = country;
        this.owner = owner;
    }

    private Warehouse(){}

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postal='" + postal + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", country='" + country + '\'' +
                ", owner=" + owner +
                '}';
    }

    public void changeName(String name) {
        this.name=name;
    }
}
