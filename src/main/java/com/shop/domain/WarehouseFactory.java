package com.shop.domain;

import com.shop.domain.dto.WarehouseDTO;

public class WarehouseFactory {

    public WarehouseFactory() {

    }

    public Warehouse build(WarehouseDTO warehouseDTO){
        Owner owner = new Owner(warehouseDTO.ownerName,Sex.valueOf(warehouseDTO.ownerSex));
        return new Warehouse(warehouseDTO.warehouseName,warehouseDTO.street,warehouseDTO.city,warehouseDTO.postal,warehouseDTO.buildingNumber,warehouseDTO.country,owner);
    }
}
