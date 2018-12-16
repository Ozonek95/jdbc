package com.shop.domain.dto;

import com.shop.domain.WarehouseFactory;

public class WarehouseDTO {
     public final String warehouseName;
     public final String street;
     public final String city;
     public final String postal;
     public final String buildingNumber;
     public final String country;
     public final String ownerName;
     public final String ownerSex;

    public WarehouseDTO(String warehouseName, String street, String city, String postal, String buildingNumber, String country, String ownerName, String ownerSex) {
        this.warehouseName = warehouseName;
        this.street = street;
        this.city = city;
        this.postal = postal;
        this.buildingNumber = buildingNumber;
        this.country = country;
        this.ownerName = ownerName;
        this.ownerSex = ownerSex.toUpperCase();
    }
}
