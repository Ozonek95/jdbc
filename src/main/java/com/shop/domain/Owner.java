package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Owner {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String sex;

    public Owner(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    private Owner() {}

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
