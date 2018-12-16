package com.shop.controller;

import com.shop.domain.Owner;
import com.shop.repository.mysql.MySqlRepositoryWarehouse;
import com.shop.domain.Warehouse;
import org.hibernate.Session;

import java.util.List;

public class ControllerWarehouse {
    private final MySqlRepositoryWarehouse mySqlRepositoryWarehouse;
    private Session session;

    public ControllerWarehouse(MySqlRepositoryWarehouse mySqlRepositoryWarehouse, Session session) {
        this.mySqlRepositoryWarehouse = mySqlRepositoryWarehouse;
        this.session=session;
    }

    public  Integer create(String name, String street, String city, String postal, String buildingNumber, String country, Owner owner) {
        Integer id = null;
        Warehouse warehouse = new Warehouse(name, street, city, postal, buildingNumber, country, owner);
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
        try {
            session.getTransaction().begin();
            mySqlRepositoryWarehouse.delete(warehouse);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public List<Warehouse> findAll() {
       return mySqlRepositoryWarehouse.findAll();
    }
}
