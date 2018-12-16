package com.shop.controller;

import com.shop.repository.mysql.MySqlRepositoryWarehouse;
import com.shop.domain.Warehouse;
import org.hibernate.Session;

public class ControllerWarehouse {
    private final MySqlRepositoryWarehouse mySqlRepositoryWarehouse;
    private Session session;

    public ControllerWarehouse(MySqlRepositoryWarehouse mySqlRepositoryWarehouse, Session session) {
        this.mySqlRepositoryWarehouse = mySqlRepositoryWarehouse;
        this.session=session;
    }

    public  Integer create(String name, String street, String city, String postal, String buildingNumber, String country) {
        Integer id = null;
        Warehouse warehouse = new Warehouse(name, street, city, postal, buildingNumber, country);
        try {
            session.getTransaction().begin();
            id = mySqlRepositoryWarehouse.create(warehouse);
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return id;
    }

    public void changeName(Integer warehouseId, String name) {
        try {
            session.getTransaction().begin();
        Warehouse warehouse = find(warehouseId);
        warehouse.changeName(name);
        mySqlRepositoryWarehouse.update(warehouse);
        session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public Warehouse find(Integer warehouseId) {
        return mySqlRepositoryWarehouse.findById(warehouseId);
    }

    public void delete(Integer warehouseId) {
        Warehouse warehouse = find(warehouseId);
        mySqlRepositoryWarehouse.delete(warehouse);
    }
}
